import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * HackerrankInAString Created by dortega on 23/05/2017.
 */
public class SolutionTest {

    @Test
    public void getSolution2() throws Exception {
        Assert.assertEquals(false,Solution.getSolution("hackerrank","rhackerank"));
    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals(false,Solution.getSolution("hackerrank","knarrekcah"));
        Assert.assertEquals(true,Solution.getSolution("hackerrank","hackerrank"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","hackerone"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","abcdefghijklmnopqrstuvwxyz"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","rhackerank"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","ahankerck"));
        Assert.assertEquals(true,Solution.getSolution("hackerrank","hacakaeararanaka"));
        Assert.assertEquals(true,Solution.getSolution("hackerrank","hhhhaaaaackkkkerrrrrrrrank"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","crackerhackerknar"));
        Assert.assertEquals(false,Solution.getSolution("hackerrank","hhhackkerbanker"));
    }

}