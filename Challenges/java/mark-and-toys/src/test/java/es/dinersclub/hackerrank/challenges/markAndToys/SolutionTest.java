package es.dinersclub.hackerrank.challenges.markAndToys;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void maximumToys() {
        {
            int expected = 3;
            int k = 15;
            int[] prices = {3,7,2,9,4};
            int actual = Solution.maximumToys(prices, k);

            assertEquals(expected,actual);

        }

        {
            int expected = 4;
            int k = 50;
            int[] prices = {1,12,5,111,200,1000,10};
            int actual = Solution.maximumToys(prices, k);

            assertEquals(expected,actual);

        }


    }
}