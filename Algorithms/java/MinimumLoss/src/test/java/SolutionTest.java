import org.junit.Assert;
import org.junit.Test;

/**
 * MinimumLoss Created by dortega on 04/05/2017.
 */
public class SolutionTest {


    @Test
    public void getSolution2() throws Exception {
        Assert.assertEquals(2,Solution.getSolution(new long[]{5,10,3}));
        Assert.assertEquals(2,Solution.getSolution(new long[]{20,7,8,2,5}));
    }

}