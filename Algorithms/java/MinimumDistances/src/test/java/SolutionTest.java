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
    public void calculateSolution() throws Exception {

        int a[] = {7,1,3,4,1,7};

        Assert.assertEquals(3,Solution.calculateSolution(a,6));

        int b[] = {1,2,3,4,10};

        Assert.assertEquals(-1,Solution.calculateSolution(b,5));
    }

}