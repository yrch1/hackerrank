import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yrch on 15/4/17.
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
        Assert.assertEquals(2,Solution.getSolution(5,1,new int[]{1,2,3,4,5}));
        Assert.assertEquals(3,Solution.getSolution(5,1,new int[]{7,2,4,6,5,9,12,11}));

    }

}