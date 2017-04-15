/**
 * Created by yrch on 15/4/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }

        long result = getSolution(n,k,x);
        System.out.println(result);
    }

    public static long getSolution(int housesCount, int range, int[] houses) {

        Arrays.sort(houses);
        long result = 0;
        int i =0;
        while(i<=housesCount){
            int nextTransmitter;
            for(nextTransmitter=i+1;nextTransmitter<housesCount;nextTransmitter++){
                if(houses[nextTransmitter]>houses[i]+range){
                    break;
                }
            }
            int rightBound;
            for(rightBound=nextTransmitter;rightBound<housesCount;rightBound++){
                if(houses[rightBound]>houses[nextTransmitter-1]+range){
                    break;
                }
            }
            i = rightBound;
            result++;
        }

        return result-1;
    }
}