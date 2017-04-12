import org.junit.Assert;

/**
 * JumpingOnTheClouds Created by dortega on 12/04/2017.
 */
public class SolutionTest {
    @org.junit.Test
    public void stepsToWin() throws Exception {
        int a[] = {0,0,1,0,0,1,0};

        Assert.assertEquals(1,Solution.stepsToWin(a,4));
        Assert.assertEquals(4,Solution.stepsToWin(a,0));

    }

}