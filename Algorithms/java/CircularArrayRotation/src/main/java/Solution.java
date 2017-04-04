/**
 * Created by dortega on 04/04/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int k = in.nextInt()%n;
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();

            long calculus1 = (n-1);
            long calculus2 = k%n;
            long calculus3 = (calculus1*calculus2)+m;
            long calculus4 = (calculus3)%n;
            System.out.println(a[(int) calculus4]);
        }
    }
}
