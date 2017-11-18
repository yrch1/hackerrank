import java.io.*;
import java.util.*;

public class Solution {


    public static boolean getSolution(char[][] grid){
        boolean result = true;
        int n = grid.length;
        if(n >1){

            for(int i=0;i<n;i++){
                Arrays.sort(grid[i]);
            }
            for(int i=0;i<n-1;i++){

                for(int j=0;j<n;j++){

                    if(grid[i][j]>grid[i+1][j]){
                        result = false;
                        i=n+2;
                        break;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int x=0;x<t;x++){

            int n = in.nextInt();
            in.nextLine();
            char [][] myGrid = new char[n][n];
            for(int i=0;i<n;i++){
                String aux = in.nextLine();
                for(int j=0;j<n;j++){
                    myGrid[i][j]=aux.charAt(j);
                }
            }


            System.out.println(getSolution(myGrid)?"YES":"NO");
        }




    }
}