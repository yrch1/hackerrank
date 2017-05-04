/**
 * Insertionsort2 Created by dortega on 04/05/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for(int i =1;i<ar.length;i++){
            int current = ar[i];
            //System.out.println(String.format("%d %d",i,current));
            int z = i-1;
            while(z>=0 && current<ar[z]){
                int temp = ar[z];
                ar[z]=ar[z+1];
                ar[z+1]=temp;
                z--;
            }
            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
