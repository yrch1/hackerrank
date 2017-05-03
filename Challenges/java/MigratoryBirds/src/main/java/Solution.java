/**
 * MigratoryBirds Created by dortega on 03/05/2017.
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
        int[] types = new int[n];
        long[] flock = new long[]{0,0,0,0,0};
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
            flock[types[types_i]-1]++;
        }
        // your code goes here
        long max = 0;
        int index = 0;
        for(int i=0;i<5;i++){
            if(flock[i]>max){
                max = flock[i];
                index = i;
            }
        }

        //System.out.println(String.format("%d %d %d %d %d",flock[0],flock[1],flock[2],flock[3],flock[4]));

        System.out.println(index+1);

    }
}
