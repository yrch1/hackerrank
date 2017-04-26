import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by yrch on 25/4/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDistance() throws Exception {
        Solution.Cell a = new Solution.Cell();
        a.setX(0);
        a.setY(0);

        Solution.Cell b = new Solution.Cell();
        b.setX(2);
        b.setY(2);


        Solution.Cell c = new Solution.Cell();
        c.setX(3);
        c.setY(2);

        Assert.assertEquals(0,Solution.getDistance(a,a));
        Assert.assertEquals(2,Solution.getDistance(a,b));
        Assert.assertEquals(3,Solution.getDistance(a,c));
    }


    @Test
    public void isValid() throws Exception {
        Solution.Cell a = new Solution.Cell(0,0);
        Assert.assertTrue(a.isValid(new Solution.Cell(2,2)));
        Assert.assertFalse(new Solution.Cell(-1,0).isValid(new Solution.Cell(2,2)));
        Assert.assertFalse(new Solution.Cell(0,-1).isValid(new Solution.Cell(2,2)));
        Assert.assertFalse(new Solution.Cell(3,3).isValid(new Solution.Cell(2,2)));
        Assert.assertTrue(new Solution.Cell(2,2).isValid(new Solution.Cell(2,2)));
    }

    @Test
    public void getPossibleMovements() throws Exception {
        Solution.Cell a = new Solution.Cell(0,0);
        List<Solution.Cell> validMovements = Solution.getPossibleMovements(a,1,2,new Solution.Cell(5,5));
        Assert.assertTrue(validMovements!=null);
        Assert.assertTrue(validMovements.size()==2);
        Assert.assertTrue(validMovements.contains(new Solution.Cell(2,1)));
        Assert.assertTrue(validMovements.contains(new Solution.Cell(1,2)));
        Assert.assertFalse(validMovements.contains(new Solution.Cell(3,2)));
    }

    @Test
    public void equals() throws Exception {
        Assert.assertEquals(new Solution.Cell(1,1),new Solution.Cell(1,1));
        Assert.assertNotEquals(new Solution.Cell(1,1),new Solution.Cell(1,2));
    }

    @Test
    public void getMovements() throws Exception {
        boolean visited[][]  = Solution.initVisited(5);
        Assert.assertEquals(1,Solution.getMovements(new Solution.Cell(3,2),new Solution.Cell(4,4),1,2,Solution.clone(visited)));
        Assert.assertEquals(2,Solution.getMovements(new Solution.Cell(0,4),new Solution.Cell(4,4),1,2,Solution.clone(visited)));
        Assert.assertEquals(3,Solution.getMovements(new Solution.Cell(2,1),new Solution.Cell(4,4),1,2,Solution.clone(visited)));
        Assert.assertEquals(4,Solution.getMovements(new Solution.Cell(0,0),new Solution.Cell(4,4),1,2,Solution.clone(visited)));

    }


}