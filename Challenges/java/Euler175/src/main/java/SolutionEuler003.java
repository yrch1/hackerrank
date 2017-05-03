/**
 * Euler175 Created by dortega on 03/05/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class SolutionEuler003 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(getSolution(n));
        }
    }

    public static long getSolution(long n){
        while (n!=1 && n%2==0){
            n = n/2;
        }
        long max;
        if(n==1){
            max = 1;
        }else{
            int i = 3;
            while(i<n/2){
                if(n%i==0){
                    n=n/i;
                    i=3;
                }else{
                    i=i+2;
                }
            }
            if(n>2){
                max = n;
            }else{
                max = i;
            }
        }
        return max;
    }
}
