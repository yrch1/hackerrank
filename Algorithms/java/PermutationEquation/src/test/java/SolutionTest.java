import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dortega on 04/04/2017.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getP() throws Exception {

        int[] v01 = {2,3,1};

        Assert.assertEquals(2,Solution.getP(v01,1));
        Assert.assertEquals(3,Solution.getP(v01,2));
        Assert.assertEquals(1,Solution.getP(v01,3));

    }

    @Test
    public void getPermutation() throws Exception {

        int[] v01 = {2,3,1};

        Assert.assertEquals(2,Solution.getPermutation(v01,1));
        Assert.assertEquals(3,Solution.getPermutation(v01,2));
        Assert.assertEquals(1,Solution.getPermutation(v01,3));
    }

}