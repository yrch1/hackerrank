import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MagicSquareForming Created by dortega on 21/04/2017.
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

        int[][] a = new int[][]{{4,9,2},{3,5,7},{8,1,5}};
        Assert.assertEquals(1,Solution.getSolution(a));


        int[][] b = new int[][]{{2,2,7},{8,6,4},{1,2,9}};
        Assert.assertEquals(16,Solution.getSolution(b));
    }


    @Test
    public void isMagic() throws Exception {

        int[][] a = new int[][]{{4,9,2},{3,5,7},{8,1,5}};
        int[][] b = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        int[][] c = new int[][]{{4,9,2},{3,5,7},{8,1,6}};
        Assert.assertFalse(Solution.isMagic(a));
        Assert.assertTrue(Solution.isMagic(b));
        Assert.assertTrue(Solution.isMagic(c));
    }
}