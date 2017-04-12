/**
 * Created by yrch on 9/4/17.
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static    Map<String,Long> myMap = new HashMap<>();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.next());
        BigInteger k = new BigInteger(in.next());

        System.out.println(super_digit(k.multiply(super_digit(n))));
    }

    public static BigInteger super_digit(BigInteger n){
        BigInteger result;
        if(n.compareTo(new BigInteger("10"))==-1){
            result = n;
        }else{
            BigInteger current = BigInteger.ZERO;
            String toTest=String.valueOf(n);
            toTest = toTest.replaceAll("0","");
            for(int i=0;i<toTest.length();i++){
                current = current.add(new BigInteger(toTest.substring(i,i+1)));
            }
            result = super_digit(current);
        }
        return result;
    }
}
