import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CtciMakingAnagrams Created by dortega on 10/05/2017.
 */
public class SolutionTest {
    @Test
    public void numberNeeded() throws Exception {
        //Assert.assertEquals(4,Solution.numberNeeded("abc","cde"));
        Assert.assertEquals(4,Solution.numberNeeded("abca","cdea"));
    }

}