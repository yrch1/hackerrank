import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yrch on 5/5/17.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {

        int[][] routes = new int[5][2];

        routes[0][0] = 1;
        routes[0][1] = 2;

        routes[1][0] = 7;
        routes[1][1] = 4;

        routes[2][0] = 7;
        routes[2][1] = 3;

        routes[3][0] = 5;
        routes[3][1] = 8;


        routes[4][0] = 1;
        routes[4][1] = 3;

        Assert.assertEquals(5, Solution.getSolution(routes));
    }
}