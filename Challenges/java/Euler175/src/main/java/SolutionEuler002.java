import java.util.Scanner;

/**
 * Euler175 Created by dortega on 03/05/2017.
 */
public class SolutionEuler002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(getSolution(n));
        }
    }


    public static long getNthFibonnaci(long n){
        long i =1;
        long j = 0;
        for(long k =0 ;k<=n-1;k++){
            long t = i+j;
            j = i;
            i = t;
        }
        return j;
    }

    public static long getSolution(long n){
        long i =0;
        long current = getNthFibonnaci(++i);
        long result = 0;
        while(current<n){
            if(current%2==0){
                result += current;
            }
            current=getNthFibonnaci(++i);
        }
        return result;
    }
}
