package kwinta.gringotts;

import kwinta.gringotts.*;
import kwinta.gringotts.dao.*;
import kwinta.gringotts.entities.*;

import org.springframework.ui.Model;
import java.util.Optional;
import java.util.List;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRUDTestTransaction
{
    @Autowired
    private TransactionRepository repo;

    @Test
    @Order(1)
    public void testRepoInstance() throws Exception
    {
        assertNotNull(repo);
    }

    @Test
    @Order(2)
    public void testCreate() throws Exception
    {
        repo.save(new Transaction(1, 17, 18, 1000, new Timestamp(System.currentTimeMillis())));
        assertTrue(repo.getVaultsTransactions(17).size() == 1);
    }

    @Test
    @Order(3)
    public void testRead() throws Exception
    {
        Transaction t = repo.getVaultsTransactions(17).get(0);
        int id = t.getTransactionId();
        assertEquals(repo.findById(id).get().getKnuts(), 1000);
    }

    @Test
    @Order(4)
    public void testUpdate() throws Exception
    {
        Transaction t = repo.getVaultsTransactions(17).get(0);
        int id = t.getTransactionId();
        t.setKnuts(999);
        repo.save(t);
        assertEquals(repo.findById(id).get().getKnuts(), 999);
    }

    @Test
    @Order(5)
    public void testDelete() throws Exception
    {
        Transaction t = repo.getVaultsTransactions(17).get(0);
        int id = t.getTransactionId();
        repo.deleteById(id);
        assertTrue(repo.getVaultsTransactions(17).size() == 0);
    }

    
}