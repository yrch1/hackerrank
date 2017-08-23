import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yrch on 23/8/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getLargestIndex(){

        Assert.assertEquals(0,Solution.getLargestIndex("0"));
        Assert.assertEquals(2,Solution.getLargestIndex("0125330"));
        Assert.assertEquals(2,Solution.getLargestIndex("hefg"));
        Assert.assertEquals(0,Solution.getLargestIndex("dkhc"));

    }

    @Test
    public void getRightMostSuccessor(){

        Assert.assertEquals(5,Solution.getRightMostSuccessor("0125330",'2'));
        Assert.assertEquals(3,Solution.getRightMostSuccessor("hefg",'f'));
        Assert.assertEquals(2,Solution.getRightMostSuccessor("dkhc",'d'));

    }

    @Test
    public void replaceCharAt(){

        Assert.assertEquals("xa",Solution.replaceCharAt("ba",0,'x'));
        Assert.assertEquals("bx",Solution.replaceCharAt("ba",1,'x'));
    }

    @Test
    public void reverseString(){

        Assert.assertEquals("ab",Solution.reverseString("ba"));
        Assert.assertEquals("abc",Solution.reverseString("cba"));
        Assert.assertEquals("abc",Solution.reverseString(Solution.reverseString("abc")));
    }

    @Test
    public void getSolution(){

        Assert.assertEquals("hcdk",Solution.getSolution("dkhc"));
        Assert.assertEquals("0130235",Solution.getSolution("0125330"));
        Assert.assertEquals("ba",Solution.getSolution("ab"));
        Assert.assertEquals("no answer",Solution.getSolution("bb"));
        Assert.assertEquals("hegf",Solution.getSolution("hefg"));
        Assert.assertEquals("dhkc",Solution.getSolution("dhck"));

        Assert.assertEquals("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw",Solution.getSolution("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw"));


    }

}