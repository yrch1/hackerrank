import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CtciArrayLeftRotation Created by dortega on 08/05/2017.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void processSolution() throws Exception {

        int a[] = new int[]{1,2,3,4,5};

        int b[] = new int[]{5, 1,2,3,4};
        Assert.assertArrayEquals(b,Solution.processSolution(5,4,a));

        int c[] = new int[]{4,5, 1,2,3};
        Assert.assertArrayEquals(c,Solution.processSolution(5,3,a));
    }

}