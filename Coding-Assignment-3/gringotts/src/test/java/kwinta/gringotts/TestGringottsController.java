package kwinta.gringotts;

import kwinta.gringotts.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

class TestGringottsController
{
    private Model model;

    @Test
    void test1() throws Exception
    {
        GringottsController controller = new GringottsController();
        assertEquals(controller.home(model), "dashboard");
    }
    // @Test
    // void test1a() throws Exception
    // {
    // }
    // @Test
    // void test1b() throws Exception
    // {
    // }
    // @Test
    // void test2() throws Exception
    // {
    // }
}
