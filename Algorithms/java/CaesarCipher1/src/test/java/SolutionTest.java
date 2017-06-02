import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CaesarCipher1 Created by dortega on 17/05/2017.
 */
public class SolutionTest {
    @Test
    public void isALetter() throws Exception {
        Assert.assertTrue(Solution.isALetter('A'));
        Assert.assertTrue(Solution.isALetter('b'));
        Assert.assertTrue(Solution.isALetter('W'));
        Assert.assertFalse(Solution.isALetter('-'));
        Assert.assertFalse(Solution.isALetter('_'));
        Assert.assertFalse(Solution.isALetter('@'));
        Assert.assertFalse(Solution.isALetter('['));
    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals("okffng-Qwvb",Solution.getSolution("middle-Outz",2));
        Assert.assertEquals("159357fwzx",Solution.getSolution("159357lcfd",98));
        Assert.assertEquals("_!",Solution.getSolution("_!",4));
        Assert.assertEquals("A",Solution.getSolution("W",4));
        Assert.assertEquals("Lipps_Asvph!",Solution.getSolution("Hello_World!",4));

    }


}