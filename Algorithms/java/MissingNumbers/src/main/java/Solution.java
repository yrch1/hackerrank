/**
 * MissingNumbers Created by dortega on 19/04/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        int max = 10000010;
        int[] cacheA = initCache(max);
        int[] cacheB = initCache(max);

        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int currentOne=in.nextInt();
            cacheA[currentOne]++;
        }


        int m = in.nextInt();
        for(int i=0;i<m;i++){
            int currentOne=in.nextInt();
            cacheB[currentOne]++;
        }
        getSolution(max, cacheA, cacheB);
    }

    public static void getSolution(int max, int[] cacheA, int[] cacheB) {
        for(int i=0;i<max;i++){
            if(cacheA[i]!=cacheB[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static int[] initCache(int max){
        int[] cache = new int[max];
        for(int i=0;i<max;i++){
            cache[i]=0;
        }
        return cache;
    }
}