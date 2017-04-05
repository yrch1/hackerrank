import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by dortega on 05/04/2017.
 */
public class SolutionTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void isValid() throws Exception {

        Assert.assertTrue(Solution.isValid("babab"));
        Assert.assertFalse(Solution.isValid("bebeeeb"));
        Assert.assertFalse(Solution.isValid("babfab"));
        Assert.assertTrue(Solution.isValid("papa"));
    }

    @org.junit.Test
    public void differentCharacters() throws Exception {

        Assert.assertEquals("a",Solution.differentCharacters("aaaaaaaaaaaa"));
        Assert.assertEquals("ab",Solution.differentCharacters("aaaabbbbbaaaaaaaa"));
        Assert.assertEquals("abc",Solution.differentCharacters("aaaabbbbbaacaaaaaa"));
    }

}