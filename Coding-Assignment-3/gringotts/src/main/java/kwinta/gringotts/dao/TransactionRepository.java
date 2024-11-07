package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Transaction;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
    @Query("SELECT t FROM Transaction t WHERE t.fromVault = ?1 OR t.toVault = ?1")
    List<Transaction> getVaultsTransactions(int v);
}
