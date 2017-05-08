/**
 * CtciArrayLeftRotation Created by dortega on 08/05/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] processSolution(int n,int k,int[] a){
        int[] result = new int[n];
        k = k%n;
        int base = n-k;
        for(int i=0;i<n;i++){
            result[(base+i)%n]=a[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] b = processSolution(n,k,a);

        for(int a_i=0; a_i < n; a_i++){
            System.out.print(b[a_i]+" ");
        }
    }
}
