import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yrch on 5/5/17.
 */
public class Solution2Test {
    @Test
    public void getMaxScore() throws Exception {
        Assert.assertEquals(6,Solution2.getSolution(new long[]{4,8,5}));
        Assert.assertEquals(6,Solution2.getSolution(new long[]{5,8,4}));
    }

}