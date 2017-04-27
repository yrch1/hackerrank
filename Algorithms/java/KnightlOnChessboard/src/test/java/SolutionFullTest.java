import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by yrch on 25/4/17.
 */
public class SolutionFullTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDistance() throws Exception {
        SolutionFull.Cell a = new SolutionFull.Cell();
        a.setX(0);
        a.setY(0);

        SolutionFull.Cell b = new SolutionFull.Cell();
        b.setX(2);
        b.setY(2);


        SolutionFull.Cell c = new SolutionFull.Cell();
        c.setX(3);
        c.setY(2);

        Assert.assertEquals(0, SolutionFull.getDistance(a,a));
        Assert.assertEquals(2, SolutionFull.getDistance(a,b));
        Assert.assertEquals(3, SolutionFull.getDistance(a,c));
    }


    @Test
    public void isValid() throws Exception {
        SolutionFull.Cell a = new SolutionFull.Cell(0,0);
        Assert.assertTrue(a.isValid(new SolutionFull.Cell(2,2)));
        Assert.assertFalse(new SolutionFull.Cell(-1,0).isValid(new SolutionFull.Cell(2,2)));
        Assert.assertFalse(new SolutionFull.Cell(0,-1).isValid(new SolutionFull.Cell(2,2)));
        Assert.assertFalse(new SolutionFull.Cell(3,3).isValid(new SolutionFull.Cell(2,2)));
        Assert.assertTrue(new SolutionFull.Cell(2,2).isValid(new SolutionFull.Cell(2,2)));
    }

    @Test
    public void getPossibleMovements() throws Exception {
        SolutionFull.Cell a = new SolutionFull.Cell(0,0);
        List<SolutionFull.Cell> validMovements = SolutionFull.getPossibleMovements(a,1,2,new SolutionFull.Cell(5,5),  SolutionFull.initVisited(5));
        Assert.assertTrue(validMovements!=null);
        Assert.assertTrue(validMovements.size()==2);
        Assert.assertTrue(validMovements.contains(new SolutionFull.Cell(2,1)));
        Assert.assertTrue(validMovements.contains(new SolutionFull.Cell(1,2)));
        Assert.assertFalse(validMovements.contains(new SolutionFull.Cell(3,2)));
    }

    @Test
    public void equals() throws Exception {
        Assert.assertEquals(new SolutionFull.Cell(1,1),new SolutionFull.Cell(1,1));
        Assert.assertNotEquals(new SolutionFull.Cell(1,1),new SolutionFull.Cell(1,2));
    }

    @Test
    public void getMovements() throws Exception {
        boolean visited[][]  = SolutionFull.initVisited(5);
        Assert.assertEquals(1, SolutionFull.getMovements(new SolutionFull.Cell(3,2),new SolutionFull.Cell(4,4),1,2, SolutionFull.clone(visited)));
       Assert.assertEquals(2, SolutionFull.getMovements(new SolutionFull.Cell(0,4),new SolutionFull.Cell(4,4),1,2, SolutionFull.clone(visited)));
        Assert.assertEquals(3, SolutionFull.getMovements(new SolutionFull.Cell(2,1),new SolutionFull.Cell(4,4),1,2, SolutionFull.clone(visited)));
        Assert.assertEquals(4, SolutionFull.getMovements(new SolutionFull.Cell(0,0),new SolutionFull.Cell(4,4),1,2, SolutionFull.clone(visited)));

    }

    @Test
    public void BFS() throws Exception {
        SolutionFull.BFS(new SolutionFull.Cell(0,0),new SolutionFull.Cell(4,4),5,1,1);
        Assert.assertEquals(1, SolutionFull.BFS(new SolutionFull.Cell(3,2),new SolutionFull.Cell(4,4),5,1,2));
        Assert.assertEquals(2, SolutionFull.BFS(new SolutionFull.Cell(0,4),new SolutionFull.Cell(4,4),5,1,2));
        Assert.assertEquals(3, SolutionFull.BFS(new SolutionFull.Cell(2,1),new SolutionFull.Cell(4,4),5,1,2));
        Assert.assertEquals(4, SolutionFull.BFS(new SolutionFull.Cell(0,0),new SolutionFull.Cell(4,4),5,1,2));

    }
}