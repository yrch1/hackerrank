import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Euler175 Created by dortega on 28/04/2017.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void f() throws Exception {
        Assert.assertEquals(1, SolutionFull.f(0));
        Assert.assertEquals(5, SolutionFull.f(10));

        Assert.assertEquals(17* SolutionFull.f(241),13* SolutionFull.f(240));
    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals("4,3,1", Solution.getSolution(13,17));
    }




    @Test
    public void toBinaryString() throws Exception {
        Assert.assertEquals("0",Integer.toBinaryString(0));
        Assert.assertEquals("1",Integer.toBinaryString(1));
        Assert.assertEquals("10",Integer.toBinaryString(2));
    }

    @Test
    public void shortenedBinaryExpansion() throws Exception{

        Assert.assertEquals("431", SolutionFull.shortenedBinaryExpansion(241));
        Assert.assertEquals("111", SolutionFull.shortenedBinaryExpansion(5));
    }

    @Test
    public void log2() throws Exception{
        Assert.assertEquals(0, SolutionFull.log2(1));
        Assert.assertEquals(1, SolutionFull.log2(3));
        Assert.assertEquals(2, SolutionFull.log2(4));
        Assert.assertEquals(3, SolutionFull.log2(9));
        Assert.assertEquals(3, SolutionFull.log2(10));
    }
}