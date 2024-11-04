package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Wizard;
import org.springframework.data.repository.CrudRepository;

public interface WizardRepository extends CrudRepository<Wizard, Integer>
{
}