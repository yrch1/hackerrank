import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yrch on 25/4/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDistance() throws Exception {
        Solution.Cell a = new Solution.Cell();
        a.setX(0);
        a.setY(0);

        Solution.Cell b = new Solution.Cell();
        b.setX(2);
        b.setY(2);


        Solution.Cell c = new Solution.Cell();
        c.setX(3);
        c.setY(2);

        Assert.assertEquals(0,Solution.getDistance(a,a));
        Assert.assertEquals(2,Solution.getDistance(a,b));
        Assert.assertEquals(3,Solution.getDistance(a,c));
    }


    @Test
    public void getDistance() throws Exception {
        Assert.assertTrue(Solution.getMovements()!=null);
    }
}