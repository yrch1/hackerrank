/**
 * Created by yrch on 9/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static    Map<String,Long> myMap = new HashMap<>();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();

        System.out.println(super_digit(k*super_digit(n)));
    }

    public static long super_digit(long n){
        long result = 0;
        if(n<10){
            result = n;
        }else{
            long current = 0;
            String toTest=String.valueOf(n);
            toTest = toTest.replaceAll("0","");
            for(int i=0;i<toTest.length();i++){
                current += Long.parseLong(toTest.substring(i,i+1));
            }
            result = super_digit(current);
        }
        return result;
    }
}

