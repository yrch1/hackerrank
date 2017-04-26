import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by yrch on 22/4/17.
 */
public class SolutionTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void whoWins() throws Exception {

        Assert.assertEquals(Solution.Players.Second,Solution.whoWins(1,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(2,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(3,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(4,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(5,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(6,Solution.Players.First));
        Assert.assertEquals(Solution.Players.Second,Solution.whoWins(7,Solution.Players.First));
        Assert.assertEquals(Solution.Players.First,Solution.whoWins(10,Solution.Players.First));


    }

}