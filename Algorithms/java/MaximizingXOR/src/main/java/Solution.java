/**
 * MaximizingXOR Created by dortega on 02/06/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static int getSolution(int l, int r){

        int maximal = 0;

        for(int a=l;a<=r;a++){
            for(int b=a;b<=r;b++){
                int candidate = a^b;
                System.out.println(String.format("xor(%d,%d) = %d",a,b,candidate));
                if(candidate > maximal){
                    maximal = candidate;
                }
            }
        }
        System.out.println("Stopping..");

        return maximal;

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();


        System.out.println(getSolution(l,r));

        in.close();

    }
}