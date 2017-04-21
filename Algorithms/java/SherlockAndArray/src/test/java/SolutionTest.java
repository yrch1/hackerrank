import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yrch on 21/4/17.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {
        Assert.assertTrue(Solution.getSolution(new int[]{1,1,1,4,3}));
        Assert.assertTrue(Solution.getSolution(new int[]{1,1,3,2}));
        Assert.assertTrue(Solution.getSolution(new int[]{1,2,1}));
        Assert.assertTrue(Solution.getSolution(new int[]{0,2}));
        Assert.assertTrue(Solution.getSolution(new int[]{0}));
        Assert.assertTrue(Solution.getSolution(new int[]{0,2,3,3}));

    }

}