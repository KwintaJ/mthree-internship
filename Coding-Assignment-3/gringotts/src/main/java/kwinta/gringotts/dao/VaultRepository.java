package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Vault;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;


public interface VaultRepository extends CrudRepository<Vault, Integer>
{
    @Query("SELECT v FROM Vault v WHERE v.wizard = ?1")
    List<Vault> findVaultsByWizard(int wizard);
}
