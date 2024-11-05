package kwinta.gringotts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController
{
    @Autowired
    private GringottsController gringottsController;

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
        int id = gringottsController.loginCheck(username, password);
        if(id < 0)
            return "login-fail";

        model.addAttribute("username", username);
        model.addAttribute("userId", id);
        model.addAttribute("vaults", gringottsController.getWizardsVaults(id));
        return "user";
    }

}