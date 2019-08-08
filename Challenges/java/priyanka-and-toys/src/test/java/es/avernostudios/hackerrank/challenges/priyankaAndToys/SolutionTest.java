package es.avernostudios.hackerrank.challenges.priyankaAndToys;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void toys() {

        {
            int[] toTest = {16,18,10,13,2,9,17,17,0,19};
            int expected = 3;
            assertEquals(3,Solution.toys(toTest));

        }
    }
}