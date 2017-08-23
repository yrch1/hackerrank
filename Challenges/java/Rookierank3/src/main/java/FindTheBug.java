import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindTheBug {

    static int[] findTheBug(String[] grid){
        int[] result = new int[2];
        // Complete this function
        for(int i=0;i<grid.length;i++){
            String current = grid[i];
            if(current.indexOf("X")!=-1){
                result[0]=i;
                result[1]=current.indexOf("X");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        // Return an array containing [r, c]
        int[] result = findTheBug(grid);

        System.out.println(String.format("%d,%d",result[0],result[1]));


    }
}
