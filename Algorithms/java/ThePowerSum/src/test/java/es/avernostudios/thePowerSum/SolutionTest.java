package es.avernostudios.thePowerSum;
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
    public void countWays() throws Exception {

        Assert.assertEquals(1,Solution.countWays(1,2));
        Assert.assertEquals(1,Solution.countWays(4,2));
        Assert.assertEquals(1,Solution.countWays(10,2));
        Assert.assertEquals(3,Solution.countWays(100,2));
    }

}