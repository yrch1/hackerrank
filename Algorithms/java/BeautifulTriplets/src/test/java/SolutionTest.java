import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by dortega on 06/04/2017.
 */
public class SolutionTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getSolution() throws Exception {
        int[] a1= {1,2,4,5,7,8,10};
        Assert.assertEquals(3,Solution.getSolution(7,3,a1));
    }

}