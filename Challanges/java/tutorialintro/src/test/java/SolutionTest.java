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
    public void getPosition() throws Exception {

        int a[] = {1,4,5,7,9,12};
        Assert.assertEquals(0,Solution.getPosition(a,1));
        Assert.assertEquals(1,Solution.getPosition(a,4));
        Assert.assertEquals(2,Solution.getPosition(a,5));
        Assert.assertEquals(3,Solution.getPosition(a,7));
        Assert.assertEquals(4,Solution.getPosition(a,9));

    }

}