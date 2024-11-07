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
class CRUDTestVault
{
    @Autowired
    private VaultRepository repo;

    @Autowired
    private WizardRepository wizardRepo;

    @Test
    @Order(1)
    public void testRepoInstance() throws Exception
    {
        assertNotNull(repo);
        assertNotNull(wizardRepo);
    }

    @Test
    @Order(2)
    public void testCreate() throws Exception
    {
        wizardRepo.save(new Wizard(1, "Generic-Name", "*****"));
        Wizard w = wizardRepo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        repo.save(new Vault(1, id, 1000, 15, 1));
        assertTrue(repo.findVaultsByWizard(id).size() == 1);
    }

    @Test
    @Order(3)
    public void testRead() throws Exception
    {
        Wizard w = wizardRepo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        Vault v = repo.findVaultsByWizard(id).get(0);
        assertEquals(v.getGalleon(), 1000);
        assertEquals(v.getSickle(), 15);
        assertEquals(v.getKnut(), 1);
    }

    @Test
    @Order(4)
    public void testUpdate() throws Exception
    {
        Wizard w = wizardRepo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        Vault vBeforeUpdate = repo.findVaultsByWizard(id).get(0);
        vBeforeUpdate.setGalleon(999);
        vBeforeUpdate.setSickle(20);
        vBeforeUpdate.setKnut(2);
        repo.save(vBeforeUpdate);
        Vault vAfterUpdate = repo.findVaultsByWizard(id).get(0);
        assertEquals(vAfterUpdate.getGalleon(), 999);
        assertEquals(vAfterUpdate.getSickle(), 20);
        assertEquals(vAfterUpdate.getKnut(), 2);
    }

    @Test
    @Order(5)
    public void testDelete() throws Exception
    {
        Wizard w = wizardRepo.findWizardByName("Generic-Name").get();
        int id = w.getId();
        Vault v = repo.findVaultsByWizard(id).get(0);
        repo.deleteById(v.getVaultNum());
        wizardRepo.deleteById(id);
        assertTrue(repo.findVaultsByWizard(id).size() == 0);
    }   
}
