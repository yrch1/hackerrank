/**
 * Created by yrch on 19/8/17.
 */
import java.io.*;
import java.util.*;


public class Solution {

    public enum Move {
        LEFT, RIGHT, UP, DOWN
    }
    static final char C_dash = (char)45;
    static final char C_m = (char)109;

    static void displayGrid(int n, char[][] grid){
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                stb.append(String.format("[%c]",grid[i][j]));
            }
            stb.append("\n");
        }
        //System.out.println(stb.toString());
    }

    static void displayPathtoPrincess(int n, char[][] grid){
        int botColumn= n/2,botRow = n/2;
        boolean finish=false;
        displayGrid(n,grid);
        //move to bottom
        for(int i=0;i<(n-n/2)-1;i++){
            System.out.println(Move.DOWN);
            grid[botRow][botColumn]=C_dash;
            grid[botRow+1][botColumn]=C_m;
            botRow++;
            displayGrid(n,grid);

        }
        for(int i=0;i<(n-n/2)-1;i++){

            System.out.println(Move.LEFT);
            grid[botRow][botColumn]=C_dash;
            if(grid[botRow][botColumn-1]!='p'){
                grid[botRow][botColumn-1]=C_m;
                botColumn--;
                displayGrid(n,grid);
            }else{
                //System.out.println("Finish");
                finish=true;
                break;
            }

        }

        if(!finish){
            //move to top
            for(int i=0;i<n-2;i++){
                System.out.println(Move.UP);
                grid[botRow][botColumn]=C_dash;
                grid[botRow-1][botColumn]=C_m;
                botRow--;
                displayGrid(n,grid);
            }
            System.out.println(Move.UP);
            if(grid[0][0]!='p'){
                grid[1][0]=C_dash;
                grid[0][0]=C_m;
                botRow=0;
                botColumn=0;
                displayGrid(n,grid);
            }else{
                // System.out.println("Finish");
                finish=true;
            }
        }


        if(!finish){
            //move to right
            for(int i=0;i<n-2;i++){
                System.out.println(Move.RIGHT);
                grid[botRow][botColumn]=C_dash;
                grid[botRow][botColumn+1]=C_m;
                botColumn++;
                displayGrid(n,grid);
            }
            System.out.println(Move.RIGHT);
            if(grid[0][n-1]!='p'){
                grid[0][n-2]=C_dash;
                grid[0][n-1]=C_m;
                botRow=0;
                botColumn=n-1;
                displayGrid(n,grid);
            }else{
                // System.out.println("Finish");
                finish=true;
            }
        }


        if(!finish){
            //move to DOWN
            for(int i=0;i<n-2;i++){
                System.out.println(Move.DOWN);
                grid[botRow][botColumn]=C_dash;
                grid[botRow+1][botColumn]=C_m;
                botRow++;
                displayGrid(n,grid);
            }

            System.out.println(Move.DOWN);
            if(grid[n-1][n-1]!='p'){
                grid[n-1][n-2]=C_dash;
                grid[n-1][n-1]=C_m;
                botRow=n-1;
                botColumn=n-1;
                displayGrid(n,grid);
            }else{
                // System.out.println("Finish");
                finish=true;
            }
        }

        displayGrid(n,grid);

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        char grid[][] = new char[m][m];
        for(int i = 0; i < m; i++) {
            String aux = in.next();
            for(int j=0;j<m;j++){
                grid[i][j] = aux.charAt(j);
            }

        }

        displayPathtoPrincess(m,grid);
    }
}