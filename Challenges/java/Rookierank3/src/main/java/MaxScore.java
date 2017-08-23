/**
 * Created by yrch on 6/5/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxScore {

    public static Map<Long, Long> myCache = new HashMap<>();

    public static long getMaxScore(List<Long> a, long runningSum) {
        // Complete this function
        long totalScore = 0;

        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            long ai = a.remove(i);
            long key = runningSum + ai;
            Long rightScore = myCache.get(key);
            if (rightScore == null) {
                rightScore = getMaxScore(a, key);
                myCache.put(key, rightScore);
            }
            long partialScore = runningSum % ai + rightScore;
            if (partialScore > totalScore) {
                totalScore = partialScore;
            }
            a.add(i, ai);
        }

        return totalScore;
    }

    public static long getSolution(List<Long> a) {

        return getMaxScore(a, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Long> a = new ArrayList<>();
        for (int a_i = 0; a_i < n; a_i++) {
            a.add(in.nextLong());
        }
        long maxScore = getSolution(a);
        System.out.println(maxScore);
    }
}