import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MinimumLoss Created by dortega on 04/05/2017.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals(2,Solution.getSolution(new int[]{5,10,3}));
        Assert.assertEquals(2,Solution.getSolution(new int[]{20,7,8,2,5}));
    }

}