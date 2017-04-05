/**
 * Created by dortega on 05/04/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {
    public static int[][] magic_mat = {
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {2, 7, 6, 9, 5, 1, 4, 3, 8},
    };

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int[] matrix = new int[9];
        for(int i=0;i<9;i++){
            matrix[i] = in.nextInt();
        }

        System.out.println(calculateCostSimple(matrix));
    }

    public static int calculateCostSimple(int[] arrayToTest){
        int cost = Integer.MAX_VALUE;
        for(int i=0;i<8;i++){
            int currentDistance = calculateDistance(magic_mat[i],arrayToTest);
            if(currentDistance<cost){
                cost = currentDistance;
            }
        }

        return cost;
    }


    public static int calculateDistance(int[] a1, int[] a2){
        int distance = 0;
        for(int i=0;i<9;i++){
            distance+= Math.abs(a1[i]-a2[i]);
        }
        return distance;
    }

    public static boolean isAMagicSquare(int[] arrayToTest){
        int r1 = arrayToTest[0]+arrayToTest[1]+arrayToTest[2];
        int r2 = arrayToTest[3]+arrayToTest[4]+arrayToTest[5];
        int r3 = arrayToTest[6]+arrayToTest[7]+arrayToTest[8];

        int c1 = arrayToTest[0]+arrayToTest[3]+arrayToTest[6];
        int c2 = arrayToTest[1]+arrayToTest[4]+arrayToTest[7];
        int c3 = arrayToTest[2]+arrayToTest[5]+arrayToTest[8];

        int d1 = arrayToTest[0]+arrayToTest[4]+arrayToTest[8];
        int d2 = arrayToTest[2]+arrayToTest[4]+arrayToTest[6];

        return r1==r2 && r2 == r3 && r3 ==c1 && c1 == c2 && c2 == c3 && c3 == d1 && d1==d2;
    }
}