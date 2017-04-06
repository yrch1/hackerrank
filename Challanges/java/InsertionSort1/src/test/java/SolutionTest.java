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
    public void insertIntoSorted() throws Exception {
        int[] a ={2,4,6,8,3};
        Solution.insertIntoSorted(a);
    }

}