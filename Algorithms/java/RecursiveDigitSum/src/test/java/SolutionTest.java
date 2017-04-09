import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by yrch on 9/4/17.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void super_digit() throws Exception {
        Assert.assertEquals(3,Solution.super_digit("12"));
        Assert.assertEquals(3,Solution.super_digit("148148148"));
        Assert.assertEquals(3,Solution.super_digit(String.valueOf(100000*Solution.super_digit("861568688536788"))));


        Scanner in = new Scanner(new File("src/test/resources/input09"));

        String toTest = in.next();
        String a = toTest.substring(0,toTest.length()/2);
        String b = toTest.substring(toTest.length()/2);


        Assert.assertEquals(4,Solution.super_digit(String.valueOf(100000*(Solution.super_digit(a)+Solution.super_digit(b)))));

    }

}