import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void getSolution() throws Exception {
        Assert.assertTrue(Solution.getSolution("We promptly judged antique ivory buckles for the next prize"));
        Assert.assertFalse(Solution.getSolution("We promptly judged antique ivory buckles for the prize"));
    }

}