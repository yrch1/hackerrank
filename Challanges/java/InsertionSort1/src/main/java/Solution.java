/**
 * Created by dortega on 06/04/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {



    public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        int e = ar[ar.length-1];
        int insertionPoint=0;
        for(;insertionPoint<ar.length-1;insertionPoint++){
            if(e<ar[insertionPoint]){
                break;
            }
        }
        for(int i=0;i-ar.length+3<insertionPoint;i++){
            ar[ar.length-i-1]=ar[ar.length-i-2];
            printArray(ar);
        }
        ar[insertionPoint]=e;
        printArray(ar);
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
