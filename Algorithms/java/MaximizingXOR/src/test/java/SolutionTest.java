import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MaximizingXOR Created by dortega on 02/06/2017.
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

        Assert.assertEquals(7,Solution.getSolution(10,15));
    }

}