package kwinta.gringotts.dao;

import kwinta.gringotts.entities.*;
import kwinta.gringotts.dao.*;
import kwinta.gringotts.exceptions.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.lang.Math;
import java.sql.Timestamp;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class BankService
{
    @Autowired
    private WizardRepository wizardRepository;
    @Autowired
    private VaultRepository vaultRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    private static final double galleonToGBP = 4.93;

    public Model loginCheck(Model model, String username, String password) throws LoginFailException
    {
        Optional<Wizard> w = wizardRepository.findWizardByName(username);
        if(!w.isPresent())
            throw new LoginFailException("login-name");

        if(!w.get().getPassword().equals(password))
            throw new LoginFailException("password-mismatch");

        model.addAttribute("username", username);
        model.addAttribute("userId", w.get().getId());
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(w.get().getId()));
        return model;
    }

    public Model simplify(Model model, int id, int vn) throws WizardNotFound, VaultNotFound, VaultForbiddenException
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            throw new WizardNotFound();
        
        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            throw new VaultNotFound();

        if(vault.get().getWizard() != w.get().getId())
            throw new VaultForbiddenException();

        Vault v = vault.get();
        int knutsToSickles = v.getKnut() / 29;
        v.setKnut(v.getKnut() - (knutsToSickles * 29));
        v.setSickle(v.getSickle() + knutsToSickles);
        int sicklesToGalleons = v.getSickle() / 17;
        v.setSickle(v.getSickle() - (sicklesToGalleons * 17));
        v.setGalleon(v.getGalleon() + sicklesToGalleons);

        vaultRepository.save(v);

        model.addAttribute("username", w.get().getName());
        model.addAttribute("userId", id);
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(id));
        return model;
    }

    public Model claimNewVaultCheck(Model model, int id) throws WizardNotFound, TooManyVaultsException
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            throw new WizardNotFound();

        if(vaultRepository.findVaultsByWizard(id).size() >= 3)
            throw new TooManyVaultsException();

        Vault v = new Vault();
        v.setWizard(id);
        v.setGalleon(0);
        v.setSickle(0);
        v.setKnut(0);
        vaultRepository.save(v);

        model.addAttribute("username", w.get().getName());
        model.addAttribute("userId", id);
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(id));
        return model;
    }

    public Model convert(Model model, int id, int vn) throws WizardNotFound, VaultNotFound, VaultForbiddenException
    {    
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            throw new WizardNotFound();

        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            throw new VaultNotFound();

        if(vault.get().getWizard() != w.get().getId())
            throw new VaultForbiddenException();

        // simulation of foreign exchange market fluctuation
        Random r = new Random();
        double randomValue = 0.005 * r.nextDouble() - 0.0025;
        double pounds = vault.get().getGalleon() * (galleonToGBP + randomValue);
        pounds *= 100; pounds = Math.round(pounds); pounds /= 100;

        model.addAttribute("exchangeValue", pounds);
        model.addAttribute("exchangedVaultNum", vn);
        model.addAttribute("username", w.get().getName());
        model.addAttribute("userId", id);
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(id));
        return model;
    }

    public Model getTransactions(Model model, int id, int vn) throws WizardNotFound, VaultNotFound, VaultForbiddenException
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            throw new WizardNotFound();

        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            throw new VaultNotFound();

        if(vault.get().getWizard() != w.get().getId())
            throw new VaultForbiddenException();

        List<Transaction> tl = transactionRepository.getVaultsTransactions(vn);

        model.addAttribute("transactions", tl);
        model.addAttribute("username", w.get().getName());
        model.addAttribute("userId", id);
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(id));
        return model;
    }

    public Model checkTransferInit(Model model, int id, int vn) throws WizardNotFound, VaultNotFound, VaultForbiddenException
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            throw new WizardNotFound();

        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            throw new VaultNotFound();

        if(vault.get().getWizard() != w.get().getId())
            throw new VaultForbiddenException();

        model.addAttribute("userId", id);
        model.addAttribute("vaultNum", vn);
        return model;
    }

    @Transactional
    public Model doTransfer(Model model, int userId, String recipient, int v1,
                            int v2, int gal, int sic, int knt) throws WizardNotFound, 
                            VaultNotFound, VaultForbiddenException, BadTransferException
    {
        Optional<Wizard> w = wizardRepository.findById(userId);
        if(!w.isPresent())
            throw new WizardNotFound();

        Optional<Vault> vault = vaultRepository.findById(v1);
        if(!vault.isPresent())
            throw new VaultNotFound();

        if(vault.get().getWizard() != w.get().getId())
            throw new VaultForbiddenException();

        if(v1 == v2)
            throw new BadTransferException("same-vault");

        int value = (493 * gal) + (29 * sic) + knt;
        if(value <= 0)
            throw new BadTransferException("bad-value");

        if(balanceInKnuts(v1) < value)
            throw new BadTransferException("low-balance");

        Optional<Wizard> w2 = wizardRepository.findWizardByName(recipient);
        if(!w2.isPresent())
            throw new BadTransferException("bad-recipient-name");

        Optional<Vault> vault2 = vaultRepository.findById(v2);
        if(!vault2.isPresent())
            throw new BadTransferException("bad-recipient-vault");

        withdraw(value, v1);
        deposit(value, v2);

        Transaction t = new Transaction();
        t.setFromVault(v1);
        t.setToVault(v2);
        t.setKnuts(value);
        t.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(t);

        model.addAttribute("username", w.get().getName());
        model.addAttribute("userId", userId);
        model.addAttribute("vaults", vaultRepository.findVaultsByWizard(userId));
        return model;
    }
    

    private void pSimplify(int vault)
    {
        Vault v = vaultRepository.findById(vault).get();

        int knutsToSickles = v.getKnut() / 29;
        v.setKnut(v.getKnut() - (knutsToSickles * 29));
        v.setSickle(v.getSickle() + knutsToSickles);

        int sicklesToGalleons = v.getSickle() / 17;
        v.setSickle(v.getSickle() - (sicklesToGalleons * 17));
        v.setGalleon(v.getGalleon() + sicklesToGalleons);

        vaultRepository.save(v);
    }

    private int balanceInKnuts(int id)
    {
        int balance = 0;
        Vault v = vaultRepository.findById(id).get();
        balance += 493 * v.getGalleon();
        balance += 29 * v.getSickle();
        balance += v.getKnut();
        return balance;
    }

    private void withdraw(int value, int id)
    {
        Vault v = vaultRepository.findById(id).get();
        int b = balanceInKnuts(id);

        v.setGalleon(0);
        v.setSickle(0);
        v.setKnut(b - value);

        vaultRepository.save(v);
        pSimplify(id);
    }

    private void deposit(int value, int id)
    {
        Vault v = vaultRepository.findById(id).get();
        v.setKnut(v.getKnut() + value);

        vaultRepository.save(v);
        pSimplify(id);
    }
}