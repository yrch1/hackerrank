import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {


        boolean[][] trackMap = new boolean[4][4];
        trackMap[1][1]=true;
        trackMap[1][2]=true;

        trackMap[2][0]=true;
        trackMap[2][1]=true;
        trackMap[2][2]=true;
        trackMap[2][3]=true;


        trackMap[3][3]=true;

        Assert.assertEquals(9,Solution.getSolution(4,4,trackMap));
    }

    @Test
    public void getSolution2() throws Exception {


        boolean[][] trackMap = new boolean[4][3];
        trackMap[1][1]=true;
        Assert.assertEquals(11,Solution.getSolution(4,3,trackMap));
    }

}