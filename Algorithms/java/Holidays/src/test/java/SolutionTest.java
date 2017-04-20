import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Holidays Created by dortega on 20/04/2017.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSolutionSlow() throws Exception {

        int A[] = new int[8];

        A[0] = 7;
        A[1] = 3;
        A[2] = 7;
        A[3] = 3;
        A[4] = 1;
        A[5] = 3;
        A[6] = 4;
        A[7] = 1;

        Assert.assertEquals(5,Solution.getSolutionSlow(A));

        int b[] = new int[8];

        b[0] = 1;
        b[1] = 1;
        b[2] = 1;
        b[3] = 1;
        b[4] = 1;
        b[5] = 1;
        b[6] = 2;
        b[7] = 3;

        Assert.assertEquals(3,Solution.getSolutionSlow(b));

        Assert.assertEquals(4,Solution.getSolutionSlow(new int[]{3,3,2,3,2,4,5,2,3}));


        int c[] = new int[2];

        c[0] = 1;
        c[1] = 1;

        Assert.assertEquals(1,Solution.getSolutionSlow(c));


        Assert.assertEquals(4,Solution.getSolutionSlow(new int[]{2,3,4,4,2,3,5}));

    }


    @Test
    public void getSolution() throws Exception {

        int A[] = new int[8];

        A[0] = 7;
        A[1] = 3;
        A[2] = 7;
        A[3] = 3;
        A[4] = 1;
        A[5] = 3;
        A[6] = 4;
        A[7] = 1;

        Assert.assertEquals(5,Solution.getSolution(A));

        int b[] = new int[8];

        b[0] = 1;
        b[1] = 1;
        b[2] = 1;
        b[3] = 1;
        b[4] = 1;
        b[5] = 1;
        b[6] = 2;
        b[7] = 3;

        Assert.assertEquals(3,Solution.getSolution(b));

        Assert.assertEquals(4,Solution.getSolution(new int[]{3,3,2,3,2,4,5,2,3}));


        int c[] = new int[2];

        c[0] = 1;
        c[1] = 1;

        Assert.assertEquals(1,Solution.getSolution(c));


        Assert.assertEquals(4,Solution.getSolution(new int[]{2,3,4,4,2,3,5}));

    }

}