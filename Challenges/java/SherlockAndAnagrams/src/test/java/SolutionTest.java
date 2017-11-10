import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void sherlockAndAnagrams() throws Exception {


        assertEquals(4,Solution.sherlockAndAnagrams("abba"));

        assertEquals(0,Solution.sherlockAndAnagrams("abcd"));


        assertEquals(3,Solution.sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(2,Solution.sherlockAndAnagrams("hucpoltgty"));
        assertEquals(2,Solution.sherlockAndAnagrams("ovarjsnrbf"));
        assertEquals(6,Solution.sherlockAndAnagrams("pvmupwjjjf"));
        assertEquals(3,Solution.sherlockAndAnagrams("iwwhrlkpek"));




    }

    @Test
    public void sherlockAndAnagrams2() throws Exception {






    }

}