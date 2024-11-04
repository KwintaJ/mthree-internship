package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Vault;
import org.springframework.data.repository.CrudRepository;

public interface VaultRepository extends CrudRepository<Vault, Integer>
{
}