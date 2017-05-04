import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Insertionsort2 Created by dortega on 04/05/2017.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertionSortPart2() throws Exception {
        int[] test1 = new int[]{1,4,3,5,6,2};
        Solution.insertionSortPart2(test1);
    }

}