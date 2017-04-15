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

        Assert.assertEquals("2 3",Solution.getSolution(100,new int[]{5,75,25}));
        Assert.assertEquals("1 4",Solution.getSolution(4,new int[]{1,4,5,3,2}));
        Assert.assertEquals("1 2",Solution.getSolution(4,new int[]{2,2,4,3}));
        Assert.assertEquals("1 3",Solution.getSolution(4,new int[]{2,3,2,3}));
        Assert.assertEquals("2 4",Solution.getSolution(4,new int[]{1,2,1,2}));
        Assert.assertEquals("2 15",Solution.getSolution(15,new int[]{1,2,1,2,1,1,1,1,1,1,1,1,1,1,13}));


    }

}