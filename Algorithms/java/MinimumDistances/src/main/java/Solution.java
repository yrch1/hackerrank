import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by dortega on 06/04/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }

        System.out.println(calculateSolution(A,n));
    }

    public static int calculateSolution(int[] a,int n){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]==a[j] && j-i<min){
                    min = j-i;
                }
            }
        }
        if(min==Integer.MAX_VALUE){
            min = -1;
        }
        return min;
    }

}