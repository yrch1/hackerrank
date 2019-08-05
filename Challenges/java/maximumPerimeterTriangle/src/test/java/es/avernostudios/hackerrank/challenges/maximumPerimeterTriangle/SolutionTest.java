package es.avernostudios.hackerrank.challenges.maximumPerimeterTriangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isAValidTriangle() {
        assertFalse(Solution.isAValidTriangle(1,2,2));
        assertFalse(Solution.isAValidTriangle(1,1,2));
        assertFalse(Solution.isAValidTriangle(1,2,3));
        assertFalse(Solution.isAValidTriangle(4,5,10));
        assertTrue(Solution.isAValidTriangle(1,1,1));
        assertTrue(Solution.isAValidTriangle(1,3,3));

        assertTrue(Solution.isAValidTriangle(3,4,5));
        assertTrue(Solution.isAValidTriangle(4,3,5));
        assertTrue(Solution.isAValidTriangle(5,4,3));
        assertTrue(Solution.isAValidTriangle(7,10,5));
        assertFalse(Solution.isAValidTriangle(5,8,3));
    }
    @Test
    void maximumPerimeterTriangle() {
        long[] candidates3= {1l,1l,1l,2l,3l,5l};
        long[] actual3 = Solution.maximumPerimeterTriangle(candidates3);
        long[] expected3= {1l,1l,1l};
        assertArrayEquals(actual3,expected3);

        long[] candidates1= {1l,1l,1l,3l,3l};
        long[] actual1 = Solution.maximumPerimeterTriangle(candidates1);
        long[] expected1= {1l,3l,3l};
        assertArrayEquals(actual1,expected1);

        long[] candidates2= {1l,2l,3l};
        long[] actual2 = Solution.maximumPerimeterTriangle(candidates2);
        long[] expected2= {-1l};
        assertArrayEquals(actual2,expected2);


        long[] candidates4= {3l,9l,2l,15l,3l};
        long[] actual4 = Solution.maximumPerimeterTriangle(candidates4);
        long[] expected4= {2l,3l,3l};
        assertArrayEquals(actual4,expected4);

        long[] candidates5= {1000000000l,1000000000l,1000000000l,1000000000l,1000000000l};
        long[] actual5 = Solution.maximumPerimeterTriangle(candidates5);
        long[] expected5= {1000000000l,1000000000l,1000000000l};
        assertArrayEquals(actual5,expected5);




    }
    
}