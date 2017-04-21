/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */
import java.io.*;
import java.util.*;

public class SolutionSlow {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SolutionSlow. */
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        boolean [][] trackMap = new boolean[n][m];

        for(int i=0;i<k;i++){
            int r = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();

            for(int j = c1;j<=c2;j++){
                trackMap[r-1][j-1]=true;
            }

        }
        
        long count = getSolution(n,m,trackMap);
        System.out.println(count);
    }

    public static long getSolution(int n,int m,boolean[][] trackMap) {
        long count =n*m;
        for(int i = 0; i<n; i++){
            for(int j =0;j<m;j++){
                if(trackMap[i][j]==true){
                    count--;
                }
            }
        }
        return count;
    }
}