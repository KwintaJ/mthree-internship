package kwinta.gringotts;

import kwinta.gringotts.entities.*;
import kwinta.gringotts.dao.*;
import kwinta.gringotts.exceptions.*;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GringottsController 
{
    @Autowired
    private WizardRepository wizardRepository;
    @Autowired
    private VaultRepository vaultRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankService bankService;

    @GetMapping("/home")
    public String home(Model model)
    {
        return "dashboard";
    }

    @GetMapping("/sign-in")
    public String login(Model model)
    {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam String username, @RequestParam String password)
    {
        try
        {
            model = bankService.loginCheck(model, username, password);
            return "user";
        }
        catch(LoginFailException e)
        {
            return "login-fail";
        }
    }

    @PostMapping("/new-vault/{id}")
    public String claimNewVault(Model model, @PathVariable("id") int id)
    {
        try
        {
            model = bankService.claimNewVaultCheck(model, id);
            return "user";
        }
        catch(TooManyVaultsException e)
        {
            return "fail";
        }
    }

    @GetMapping("simplify-vault/{id}/{vn}")
    public String simplifyVault(Model model, @PathVariable("id") int id, @PathVariable("vn") int vault)
    {
        try
        {
            model = bankService.simplify(model, id, vault);
            return "user";
        }
        catch(RuntimeException e)
        {
            return "fail";
        }
    }

    @GetMapping("/{id}/transactions/{vn}")
    public ResponseEntity<List<Transaction>> getWizardsTransactionFromVault(@PathVariable("id") int id, 
                                                              @PathVariable("vn") int vn)
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if(vault.get().getWizard() != w.get().getId())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        List<Transaction> tl = transactionRepository.getVaultsTransactions(vn);
        return ResponseEntity.of(Optional.of(tl));
    }

    @PutMapping("/{id}/transfer/from/{v1}/to/{v2}/{value}")
    public ResponseEntity<Vault> transfer(@PathVariable("id") int id, 
                                          @PathVariable("v1") int v1, 
                                          @PathVariable("v2") int v2, 
                                          @PathVariable("value") int value)
    {
        if(v1 == v2)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if(value <= 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Vault> vault1 = vaultRepository.findById(v1);
        if(!vault1.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if(vault1.get().getWizard() != w.get().getId())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if(bankService.balanceInKnuts(v1) < value)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        Optional<Vault> vault2 = vaultRepository.findById(v2);
        if(!vault2.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        bankService.doTransfer(v1, v2, value);
        return ResponseEntity.of(vaultRepository.findById(v1));
    }

    @GetMapping("/{id}/convert/{vn}")
    public ResponseEntity<Double> getGBPFromVault(@PathVariable("id") int id, 
                                                   @PathVariable("vn") int vn)
    {
        Optional<Wizard> w = wizardRepository.findById(id);
        if(!w.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Optional<Vault> vault = vaultRepository.findById(vn);
        if(!vault.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if(vault.get().getWizard() != w.get().getId())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.of(Optional.of(bankService.convert(vn)));
    }
} 
    