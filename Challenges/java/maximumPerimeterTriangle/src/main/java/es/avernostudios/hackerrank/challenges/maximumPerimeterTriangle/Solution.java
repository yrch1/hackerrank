package es.avernostudios.hackerrank.challenges.maximumPerimeterTriangle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    static boolean isAValidTriangle(long a, long b, long c){

        boolean result=false;
        if(a+b>c && a+c>b && b+c>a){
            result = true;
        }

        return result;
    }

    static void reverse(long a[]) {
        int n = a.length;
        long[] b = new long[a.length];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }


    // Complete the maximumPerimeterTriangle function below.
    static long[] maximumPerimeterTriangle(long[] sticks) {
        long[] result = new long[3];
        long maxPerimeter = 0;

        Arrays.sort(sticks);
        Solution.reverse(sticks);

        for(int i=0;i<sticks.length-2;i++) {
            if (isAValidTriangle(sticks[i], sticks[i + 1], sticks[i + 2])) {
                System.out.println(String.format("Candidates %d - %d - %d", sticks[i], sticks[i + 1], sticks[i + 2]));
                long actualPerimeter = sticks[i] + sticks[i + 1] + sticks[i + 2];
                if (actualPerimeter > maxPerimeter) {
                    maxPerimeter = actualPerimeter;
                    result[0] = sticks[i];
                    result[1] = sticks[i + 1];
                    result[2] = sticks[i + 2];
                }
            }
        }

        if(maxPerimeter==0){
            result = new long[]{-1};
        }else{
            Arrays.sort(result);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] sticks = new long[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long sticksItem = Long.parseLong(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        long[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}