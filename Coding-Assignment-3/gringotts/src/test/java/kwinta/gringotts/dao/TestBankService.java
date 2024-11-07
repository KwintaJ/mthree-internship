package kwinta.gringotts;

import kwinta.gringotts.dao.BankService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TestBankService
{
    @Test
    void test1() throws Exception
    {
        BankService bankService = new BankService();
        assertNotNull(bankService);
    }
}
