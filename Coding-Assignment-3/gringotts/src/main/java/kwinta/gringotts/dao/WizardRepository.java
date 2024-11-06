package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Wizard;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface WizardRepository extends CrudRepository<Wizard, Integer>
{
    @Query("SELECT w FROM Wizard w WHERE w.name = ?1")
    Optional<Wizard> findWizardByName(String name);
}