import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Euler175 Created by dortega on 03/05/2017.
 */
public class SolutionEuler003Test {
    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals(5,SolutionEuler003.getSolution(10));
        Assert.assertEquals(11,SolutionEuler003.getSolution(11));
        Assert.assertEquals(11,SolutionEuler003.getSolution(33));
        Assert.assertEquals(11,SolutionEuler003.getSolution(44));
        Assert.assertEquals(11,SolutionEuler003.getSolution(121));
        Assert.assertEquals(29,SolutionEuler003.getSolution(13195));
    }

}