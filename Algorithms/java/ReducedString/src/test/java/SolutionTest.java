import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ReducedString Created by dortega on 17/05/2017.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals("abd",Solution.getSolution("aaabccddd"));
        Assert.assertEquals("Empty String",Solution.getSolution("aa"));
    }



}