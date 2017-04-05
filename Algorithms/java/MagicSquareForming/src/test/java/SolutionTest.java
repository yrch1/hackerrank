import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dortega on 05/04/2017.
 */
public class SolutionTest {
    @Test
    public void isAMagicSquare() throws Exception {

        int[] t1 = {4,9,2,3,5,7,8,1,5};
        int[] t2 = {4,9,2,3,5,7,8,1,6};
        Assert.assertTrue(!Solution.isAMagicSquare(t1));
        Assert.assertTrue(Solution.isAMagicSquare(t2));
    }

    @Test
    public void calculateCost() throws Exception {

        int[] t1 = {4,9,2,3,5,7,8,1,5};
        Assert.assertEquals(1,Solution.calculateCostSimple(t1));
    }

    @Test
    public void calculateCost2() throws Exception {

        int[] t1 = {1,9,2,3,5,7,8,1,6};
        Assert.assertEquals(3,Solution.calculateCostSimple(t1));
    }

    @Test
    public void calculateDistance() throws Exception {

        int[] t1 = {1,9,2,3,5,7,8,1,1};
        int[] t2= {2,9,2,3,5,7,8,1,1};
        int[] t3= {3,9,2,3,5,7,8,1,1};
        int[] t4= {3,9,2,3,5,7,8,1,8};
        Assert.assertEquals(0,Solution.calculateDistance(t1,t1));
        Assert.assertEquals(1,Solution.calculateDistance(t1,t2));
        Assert.assertEquals(2,Solution.calculateDistance(t1,t3));
        Assert.assertEquals(9,Solution.calculateDistance(t1,t4));

    }
}