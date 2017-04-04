/**
 * Created by dortega on 04/04/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int[] p = new int[n];
        for(int i =0;i<n;i++){
            p[i]= in.nextInt();
        }

        for(int i=1;i<n+1;i++){
            int result = getPermutation(p,i);
            System.out.println(result);
        }

    }

    public static int getP(int[] p, int x){
        return p[x-1];
    }

    public static int getPermutation(int[] p, int x) {
        int result = -1;
        for(int k =1;x<=p.length;k++){
            if(x==getP(p,k)){
                //System.out.println(x+" == p("+k+")");
                for(int j=1;j<=p.length;j++){
                    if(k==getP(p,j)) {
                  //      System.out.println(x + " == p(p(" + j + "))");
                        return j;
                    }
                }


            }
        }
        return result;
    }
}
