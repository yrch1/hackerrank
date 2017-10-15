package es.avernostudios.acmIcpcTeam;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void countOnes() {
        Assert.assertEquals(Solution.countOnes("111"),3);
        Assert.assertEquals(Solution.countOnes("100000011000000000"),3);
        Assert.assertEquals(Solution.countOnes("000"),0);
        Assert.assertEquals(Solution.countOnes("1"),1);
    }

    @Test
    public void maxNumberOfTopics() {

        Solution.initCache(5);
        String[] topics = new String[4];

        topics[0]="10101";
        topics[1]="11100";
        topics[2]="11010";
        topics[3]="00101";

        Assert.assertEquals(Solution.maxNumberOfTopics(topics),5);
    }

    @Test
    public void maxNumberOfTopics2() {

        Solution.initCache(5);
        String[] topics = new String[4];

        topics[0]="10100";
        topics[1]="11100";
        topics[2]="11010";
        topics[3]="00100";

        Assert.assertEquals(Solution.maxNumberOfTopics(topics),4);
    }

    @Test
    public void maxNumberOfTopics3() {

        Solution.initCache(5);
        String[] topics = new String[4];

        topics[0]="00000";
        topics[1]="00000";
        topics[2]="00000";
        topics[3]="00000";

        Assert.assertEquals(Solution.maxNumberOfTopics(topics),0);
    }
}