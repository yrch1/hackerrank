import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Euler175 Created by dortega on 03/05/2017.
 */
public class SolutionEuler002Test {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSolution() throws Exception {
        Assert.assertEquals(10,SolutionEuler002.getSolution(10));
        Assert.assertEquals(44,SolutionEuler002.getSolution(100));
        Assert.assertEquals(188,SolutionEuler002.getSolution(145));
    }

    @Test
    public void getNthFibonnaci() throws Exception {
        Assert.assertEquals(0,SolutionEuler002.getNthFibonnaci(0));
        Assert.assertEquals(1,SolutionEuler002.getNthFibonnaci(1));
        Assert.assertEquals(1,SolutionEuler002.getNthFibonnaci(2));

        Assert.assertEquals(2,SolutionEuler002.getNthFibonnaci(3));
        Assert.assertEquals(3,SolutionEuler002.getNthFibonnaci(4));
        Assert.assertEquals(5,SolutionEuler002.getNthFibonnaci(5));
    }



}