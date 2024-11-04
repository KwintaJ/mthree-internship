package kwinta.gringotts;

import kwinta.gringotts.entities.Wizard;
import kwinta.gringotts.entities.Vault;
import kwinta.gringotts.entities.Transaction;
import kwinta.gringotts.dao.WizardRepository;
import kwinta.gringotts.dao.VaultRepository;
import kwinta.gringotts.dao.TransactionRepository;

import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GringottsApplication
{
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(GringottsApplication.class, args);
        WizardRepository wizardRepository= context.getBean(WizardRepository.class);

        System.out.println("The Bank has been opened!");

        Optional<Wizard> resultWizard = wizardRepository.findById(10000332);
        Wizard wizardFound = resultWizard.get();
        System.out.println(wizardFound);
    }
}
