package es.avernostudios.hackerrank.challenges.twoCharacters;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isValid() {

        assertTrue(Solution.isValid("a"));
        assertTrue(Solution.isValid("b"));
        assertTrue(Solution.isValid("ab"));
        assertTrue(Solution.isValid("abab"));
        assertTrue(Solution.isValid("cbc"));
        assertFalse(Solution.isValid("cc"));
        assertTrue(Solution.isValid("ababc"));
        assertTrue(Solution.isValid("abcabc"));
        assertTrue(Solution.isValid("babab"));
        assertFalse(Solution.isValid("abccaada"));

    }

    @org.junit.jupiter.api.Test
    void twoCharaters() {


        assertEquals(8,Solution.twoCharacters("asdcbsdcagfsdbgdfanfghbsfdab"));
        assertEquals(6,Solution.twoCharacters("txnbvnzdvasknhlmcpkbxdvofimsvqbvkswlkrchohwuplfujvlwpxtlcixpajjpaskrnjneelqdbxtiyeianqjqaikbukpicrwpnjvfpzolcredzmfaznnzd"));
        assertEquals(2,Solution.twoCharacters("ab"));
        assertEquals(5,Solution.twoCharacters("beabeefeab"));
        assertEquals(0,Solution.twoCharacters("asvkugfiugsalddlasguifgukvsa"));



    }

    @org.junit.jupiter.api.Test
    void printCombination() {

        Set<Character> a = new HashSet<>();
        a.add('a');
        a.add('b');
        a.add('c');


        char[] aux = new char[a.size()];
        int i=0;
        for (Character x : a) {
            aux[i++] = x;
        }

        List<String>  actual=Solution.getCombination(aux,2);

        List<String>  expected = new ArrayList<>();

        expected.add("ab");
        expected.add("ac");
        expected.add("bc");

        Collections.sort(actual);
        Collections.sort(expected);

        assertEquals(expected,actual);
    }

}