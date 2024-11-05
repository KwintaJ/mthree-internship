package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Wizard;
import kwinta.gringotts.entities.Vault;
import kwinta.gringotts.entities.Transaction;
import kwinta.gringotts.dao.WizardRepository;
import kwinta.gringotts.dao.VaultRepository;
import kwinta.gringotts.dao.TransactionRepository;

import java.util.List;
import java.util.Optional;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class BankService
{
    @Autowired
    private VaultRepository vaultRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public int balanceInKnuts(int id)
    {
        int balance = 0;
        Vault v = vaultRepository.findById(id).get();
        balance += 493 * v.getGalleon();
        balance += 29 * v.getSickle();
        balance += v.getKnut();
        return balance;
    }

    private void simplify(int id)
    {
        Vault v = vaultRepository.findById(id).get();

        int knutsToSickles = v.getKnut() / 29;
        v.setKnut(v.getKnut() - (knutsToSickles * 29));
        v.setSickle(v.getSickle() + knutsToSickles);

        int sicklesToGalleons = v.getSickle() / 17;
        v.setSickle(v.getSickle() - (sicklesToGalleons * 17));
        v.setGalleon(v.getGalleon() + sicklesToGalleons);

        vaultRepository.save(v);
    }

    private void withdraw(int value, int id)
    {
        Vault v = vaultRepository.findById(id).get();
        int b = balanceInKnuts(id);

        v.setGalleon(0);
        v.setSickle(0);
        v.setKnut(b - value);

        vaultRepository.save(v);
        simplify(id);
    }

    private void deposit(int value, int id)
    {
        Vault v = vaultRepository.findById(id).get();
        v.setKnut(v.getKnut() + value);

        vaultRepository.save(v);
        simplify(id);
    }

    @Transactional
    public void doTransfer(int v1, int v2, int value)
    {
        withdraw(value, v1);
        deposit(value, v2);
        Transaction t = new Transaction();
        t.setFromVault(v1);
        t.setToVault(v2);
        t.setKnuts(value);
        t.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(t);
    }
}