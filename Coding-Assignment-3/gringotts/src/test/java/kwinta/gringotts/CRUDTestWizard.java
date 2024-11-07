package kwinta.gringotts;

import kwinta.gringotts.*;
import kwinta.gringotts.dao.*;
import kwinta.gringotts.entities.*;

import org.springframework.ui.Model;
import java.util.Optional;
import java.util.List;

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
class CRUDTestWizard
{
    @Autowired
    private WizardRepository repo;

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
        repo.save(new Wizard(1, "Generic-Name", "*****"));
        assertTrue(repo.findWizardByName("Generic-Name").isPresent());
    }

    @Test
    @Order(3)
    public void testRead() throws Exception
    {
        Wizard w = repo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        assertEquals(repo.findById(id).get().getPassword(), "*****");
    }

    @Test
    @Order(4)
    public void testUpdate() throws Exception
    {
        Wizard w = repo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        w.setName("Generic-Name-2");
        repo.save(w);
        assertEquals(repo.findById(id).get().getName(), "Generic-Name-2");
    }

    @Test
    @Order(5)
    public void testDelete() throws Exception
    {
        Wizard w = repo.findWizardByName("Generic-Name-2").get();
        int id = w.getId();
        repo.deleteById(id);
        assertFalse(repo.findById(id).isPresent());
    }
}
