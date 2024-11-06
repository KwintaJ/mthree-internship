package kwinta.gringotts;

import kwinta.gringotts.entities.*;
import kwinta.gringotts.dao.*;
import kwinta.gringotts.exceptions.*;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping("/new-user")
    public String newUser(Model model, @RequestParam String username, @RequestParam String password)
    {
        try
        {
            model = bankService.checkNewWizard(model, username, password);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/go-back")
    public String goBack(Model model, @RequestParam int userId)
    {
        try
        {
            model = bankService.checkUser(model, userId);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/account/{id}")
    public String showAccount(Model model, @PathVariable("id") int id)
    {
        try
        {
            model = bankService.checkUser(model, id);
            return "account";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/delete-account")
    public String deleteWizard(Model model, @RequestParam int userId)
    {
        try
        {
            bankService.deleteUser(model, userId);
            return "dashboard";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam String username, @RequestParam String password)
    {
        try
        {
            model = bankService.checkLogin(model, username, password);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @PostMapping("/new-vault/{id}")
    public String claimNewVault(Model model, @PathVariable("id") int id)
    {
        try
        {
            model = bankService.checkNewVaultClaim(model, id);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
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
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/exchange")
    public String exchange(Model model, @RequestParam int userId, @RequestParam int vaultNum)
    {
        try
        {
            model = bankService.convert(model, userId, vaultNum);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/transactions")
    public String getVaultsTransactions(Model model, @RequestParam int userId, @RequestParam int vaultNum)
    {
        try
        {
            model = bankService.getTransactions(model, userId, vaultNum);
            return "transaction-history";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @GetMapping("/transfer-init")
    public String transferInit(Model model, @RequestParam int userId, @RequestParam int vaultNum)
    {
        try
        {
            model = bankService.checkTransferInit(model, userId, vaultNum);
            return "transfer-page";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }

    @PostMapping("/transfer-go")
    public String transferGo(Model model, @RequestParam String recipient, @RequestParam int v2,
                            @RequestParam int gal, @RequestParam int sic, @RequestParam int knt,
                            @RequestParam int userId, @RequestParam int v1)
    {
        try
        {
            model = bankService.doTransfer(model, userId, recipient, v1, v2, gal, sic, knt);
            return "user";
        }
        catch(GringottsException e)
        {
            return "fail-" + e.getMessage();
        }
        catch(Exception e)
        {
            return "fail-generic";
        }
    }
} 
    