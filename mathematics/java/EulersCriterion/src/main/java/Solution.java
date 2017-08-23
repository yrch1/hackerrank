/**
 * Created by yrch on 30/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            System.out.println(getSolution(in.nextInt(),in.nextInt()) ? "YES" : "NO");
        }
    }

    public static boolean getSolution(int a, int m) {
        boolean result = false;
        long currentMCD = Math.abs(mcd(a,m));
        if(a>2 && currentMCD==1 ){
            long aux = powerN(a,(m-1)/2);

            long jacobi =jacobi(aux,m);

            result = jacobi ==1;
        }

        return result;
    }

    public static long jacobi(long a, long n) {
        long ans=1;

        if (a == 0)
            ans = (n == 1) ? 1 : 0;
        else if (a == 2) {
            switch ( (int)n % 8 ) {
                case 1:
                case 7:
                    ans = 1;
                    break;
                case 3:
                case 5:
                    ans = -1;
                    break;
            }
        }
        else if ( a >= n )
            ans = jacobi(a%n, n);
        else if ( a % 2 == 0 )
            ans = jacobi(2,n)*jacobi(a/2, n);
        else
            ans = ( a % 4 == 3 && n % 4 == 3 ) ? -jacobi(n,a) : jacobi(n,a);
        return ans;
    }

    public static long mcd(long a, long b){
        long result;
        if(b==0){
            result = a;
        }else{
            result = mcd(b,a % b);
        }
        return result;
    }

    public static long powerN(int base, int exp) {
        int result = 1;
        while(exp!=0){
            int aux = exp & 1;
            if(aux ==1){
                result *= base;
            }
            exp >>=1;
            base*=base;
        }
        return result;
    }
}
