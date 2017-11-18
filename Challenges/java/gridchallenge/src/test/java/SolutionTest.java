import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getSolutionTest0() throws Exception {

        char[][] myGrid = new char[][]{
                {'e','b','a','c','d'}
        };


        assertTrue(Solution.getSolution(myGrid));
    }

    @Test
    public void getSolutionTest1() throws Exception {

        char[][] myGrid = new char[][]{
                {'e','b','a','c','d'}
                ,{'f','g','h','i','j'}
                ,{'o','l','m','k','n'}
                ,{'t','r','p','q','s'}
                ,{'x','y','w','u','v'}
                };


        assertTrue(Solution.getSolution(myGrid));
    }


    @Test
    public void getSolutionTest2() throws Exception {

        char[][] myGrid = new char[][]{
                {'k','c'}
                ,{'i','u'}
        };


        assertTrue(Solution.getSolution(myGrid));
    }

    @Test
    public void getSolutionTest3() throws Exception {

        char[][] myGrid = new char[][]{
                {'u','x','f'}
                ,{'v','o','f'}
                ,{'h','m','p'}
        };


        assertFalse(Solution.getSolution(myGrid));
    }
}