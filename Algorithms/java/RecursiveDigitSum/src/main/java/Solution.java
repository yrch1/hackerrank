/**
 * Created by yrch on 9/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        String toTest = String.valueOf(n);

        System.out.println(super_digit(String.valueOf(k*super_digit(toTest))));
    }

    public static long super_digit(String toTest){
        long result = 0;
        if(toTest.length()==1){
            result = Long.parseLong(toTest);
        }else{
            long current = 0;
            for(int i=0;i<toTest.length();i++){
                current += Long.parseLong(toTest.substring(i,i+1));
            }
            result = super_digit(String.valueOf(current));
        }
        return result;
    }
}