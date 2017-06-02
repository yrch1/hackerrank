import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * FunnyString Created by dortega on 18/05/2017.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {
        Assert.assertTrue(Solution.getSolution("acxz"));
        Assert.assertTrue(Solution.getSolution("acxz"));
        Assert.assertFalse(Solution.getSolution("bcxz"));
    }

}