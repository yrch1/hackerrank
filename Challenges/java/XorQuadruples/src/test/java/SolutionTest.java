import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by yrch on 13/4/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void getQuadruples() throws Exception {
        Assert.assertEquals(11,Solution.getQuadruples(1,2,3,4));



    }

    @Test
    public void getQuadruplesHard() throws Exception {


        Assert.assertEquals(127535297312l,Solution.getQuadruples(1150 ,1547,853,423));


    }


}