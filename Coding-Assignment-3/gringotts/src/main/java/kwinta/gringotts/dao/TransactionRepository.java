package kwinta.gringotts.dao;

import kwinta.gringotts.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
}