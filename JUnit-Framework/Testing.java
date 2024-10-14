import toTest.*;

import junit.framework.TestCase;
import org.junit.Test;

public class Testing extends TestCase
{
    @Test
    public void testLogic1()
    {
        App a1 = new App();
        assertEquals(-1, a1.logic("abcdefghi"));
    }    

    @Test
    public void testLogic2()
    {
        App a2 = new App();
        assertEquals(0, a2.logic("abc"));
    }
}