import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Euler175 Created by dortega on 28/04/2017.
 */
public class SolutionFull {


    public static int log2(int x) {
        int y,v;
        // No log of 0 or negative
        if (x <= 0) {
            throw new IllegalArgumentException(""+x+" <= 0");
        }
        // Calculate log2 (it's actually floor log2)
        v = x;
        y = -1;
        while (v>0) {
            v >>=1;
            y++;
        }
        return y;
    }

    public static long f(int n){
        long result =0;
        if(n==0){
            result =1;
        }else{
            long aux = log2(n);
            for(long i=0;i<=aux;i++){
                for(long j=i;j<=aux;j++){
                    long x = (long)Math.pow(2,i);
                    long y = (long)Math.pow(2,j);
                    System.out.println(String.format("%d-%d -> %d,%d,%d,%d",i,j,x+y,x+x+y,x+y+y,x+y+y+x));
                    if(x+y==n){
                        result++;
                    }
                    if(2*x+y==n){
                        result++;
                    }
                    if(x+2*y==n){
                        result++;
                    }
                    if(2*x+2*y==n){
                        result++;
                    }
                }
            }
            System.out.print(aux);
        }
        return result;
    }


    public static String shortenedBinaryExpansion(int n) {
        StringBuilder result = new StringBuilder();
        String temp = Integer.toBinaryString(n);
        int count = 0;
        char initial = temp.charAt(0);
        for(int i=0;i<temp.length();i++){
            if(initial==temp.charAt(i)){
                count++;
            }else{
                result.append(count);
                count = 1;
                initial=temp.charAt(i);
            }
        }
        result.append(count);
        return result.toString();
    }
}
