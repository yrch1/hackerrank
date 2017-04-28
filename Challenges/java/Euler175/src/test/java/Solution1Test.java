import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Euler175 Created by dortega on 28/04/2017.
 */
public class Solution1Test {


    @Test
    public void sumOfMultipleOf() throws Exception {
        Assert.assertEquals(18,Solution1.sumOfMultipleOf(10,3));
        Assert.assertEquals(5,Solution1.sumOfMultipleOf(10,5));
    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals(8,Solution1.getSolution(6));
        Assert.assertEquals(23,Solution1.getSolution(10));
        Assert.assertEquals(2318,Solution1.getSolution(100));
        Assert.assertEquals(233168,Solution1.getSolution(1000));
    }

}