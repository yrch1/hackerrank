import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yrch on 30/4/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertFalse(Solution.getSolution(5,7));
        Assert.assertTrue(Solution.getSolution(4,7));
        Assert.assertTrue(Solution.getSolution(0,41));
    }


    @Test
    public void powerN() throws Exception {
        Assert.assertEquals(8,Solution.powerN(2,3));
    }

}