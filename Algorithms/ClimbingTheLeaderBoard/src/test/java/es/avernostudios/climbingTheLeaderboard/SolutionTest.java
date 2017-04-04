package es.avernostudios.climbingTheLeaderboard;

import org.junit.Assert;

/**
 * Created by dortega on 03/04/2017.
 */
public class SolutionTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getRankPosition() throws Exception {

        Integer[] array1= {10};
        Integer[] array2= {10,20};
        Integer[] array3= {10,20,30,40,50};

        Integer[] array4= {10,20,40,50,100};
        Integer[] array5= {10,20,40,50};

        Assert.assertEquals(1,Solution.getRankPosition(new Integer[]{},25));

        Assert.assertEquals(1,Solution.getRankPosition(array2,25));

        Assert.assertEquals(4,Solution.getRankPosition(array3,25));

        Assert.assertEquals(1,Solution.getRankPosition(array1,25));
        Assert.assertEquals(2,Solution.getRankPosition(array1,5));

        Assert.assertEquals(3,Solution.getRankPosition(array2,5));
        Assert.assertEquals(2,Solution.getRankPosition(array2,15));
        Assert.assertEquals(1,Solution.getRankPosition(array2,25));


        Assert.assertEquals(6,Solution.getRankPosition(array4,5));
        Assert.assertEquals(4,Solution.getRankPosition(array4,25));
        Assert.assertEquals(4,Solution.getRankPosition(array4,20));
        Assert.assertEquals(4,Solution.getRankPosition(array4,21));
        Assert.assertEquals(4,Solution.getRankPosition(array4,22));
        Assert.assertEquals(3,Solution.getRankPosition(array4,40));
        Assert.assertEquals(3,Solution.getRankPosition(array4,41));
        Assert.assertEquals(2,Solution.getRankPosition(array4,50));
        Assert.assertEquals(1,Solution.getRankPosition(array4,120));



        Assert.assertEquals(5,Solution.getRankPosition(array5,5));
        Assert.assertEquals(3,Solution.getRankPosition(array5,25));
        Assert.assertEquals(3,Solution.getRankPosition(array5,20));
        Assert.assertEquals(3,Solution.getRankPosition(array5,21));
        Assert.assertEquals(3,Solution.getRankPosition(array5,22));
        Assert.assertEquals(2,Solution.getRankPosition(array5,40));
        Assert.assertEquals(2,Solution.getRankPosition(array5,41));
        Assert.assertEquals(1,Solution.getRankPosition(array5,50));

    }

}