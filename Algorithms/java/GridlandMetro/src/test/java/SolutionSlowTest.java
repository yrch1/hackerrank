import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */
public class SolutionSlowTest {
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

        Assert.assertEquals(9, SolutionSlow.getSolution(4,4,trackMap));
    }

    @Test
    public void getSolution2() throws Exception {


        boolean[][] trackMap = new boolean[4][3];
        trackMap[1][1]=true;
        Assert.assertEquals(11, SolutionSlow.getSolution(4,3,trackMap));
    }

    @Test
    public void removeOverlap() throws Exception {

        Map<Integer,Integer> toTest = new TreeMap<>();
        toTest.put(1,3);
        toTest.put(2,4);

        toTest.put(9,14);
        toTest.put(10,18);

        Solution.removeOverlap(toTest);

        Assert.assertTrue(toTest.containsKey(1));
        Assert.assertTrue(toTest.containsKey(9));
        Assert.assertFalse(toTest.containsKey(2));
        Assert.assertFalse(toTest.containsKey(10));


        Assert.assertEquals(4,toTest.get(1).intValue());
        Assert.assertEquals(18,toTest.get(9).intValue());
    }

    @Test
    public void removeOverlap2() throws Exception {

        Map<Integer,Integer> toTest = new TreeMap<>();
        toTest.put(1,2);
        toTest.put(2,3);

        toTest.put(12,14);
        toTest.put(10,14);

        Solution.removeOverlap(toTest);

        Assert.assertTrue(toTest.containsKey(1));
        Assert.assertFalse(toTest.containsKey(2));
        Assert.assertTrue(toTest.containsKey(10));
        Assert.assertFalse(toTest.containsKey(12));


        Assert.assertEquals(3,toTest.get(1).intValue());
        Assert.assertEquals(14,toTest.get(10).intValue());
    }

    @Test
    public void removeOverlap3() throws Exception {

        Map<Integer,Integer> toTest = new TreeMap<>();
        toTest.put(1,5);
        toTest.put(2,4);

        toTest.put(8,8);


        Solution.removeOverlap(toTest);

        Assert.assertTrue(toTest.containsKey(1));
        Assert.assertFalse(toTest.containsKey(2));
        Assert.assertTrue(toTest.containsKey(8));


        Assert.assertEquals(5,toTest.get(1).intValue());
        Assert.assertEquals(8,toTest.get(8).intValue());
    }

}