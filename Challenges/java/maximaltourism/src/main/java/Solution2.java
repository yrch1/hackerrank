/**
 * Created by yrch on 5/5/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    public static Map<String, Long> myCache = new HashMap<>();

    public static long getMaxScore(long[] a,long runningSum){
        // Complete this function
        long totalScore=0;

        for(int i=0;i<a.length;i++){
            long ai = a[i];
            totalScore += runningSum%ai;
            runningSum+=ai;

        }

        return totalScore;
    }

    public static long getSolution(long[] myA) {
        long max = 0;
        int i =0;
        do {
            long current = getMaxScore(myA,0);
            if(current>max) {
                max = current;
            }

        }while( next_permutation( myA ));
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i]=in.nextLong();
        }
        long maxScore = getSolution(a);
        System.out.println(maxScore);
    }


    public static boolean next_permutation(long[] a)
    {
        int N=a.length;
        int i=N-2;
        for (; i>=0; i--) if (a[i]<a[i+1]) break;
        if (i<0) return false;

        for (int j=N-1; j>=i; j--)
        {
            if (a[j]>a[i])
            {
                long temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                break;
            }
        }
        for (int j=i+1; j<(N+i+1)/2; j++)		//reverse from a[i+1] to a[N-1]
        {
            long temp=a[j];
            a[j]=a[N+i-j];
            a[N+i-j]=temp;
        }
        return true;
    }
}
