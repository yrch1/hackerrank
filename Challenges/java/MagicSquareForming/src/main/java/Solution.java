/**
 * MagicSquareForming Created by dortega on 21/04/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }

        int result = getSolution(s);
        System.out.print(result);
        //  Print the minimum cost of converting 's' into a magic square

    }

    public static boolean isMagic(int[][] s){
        int h0 = s[0][0]+s[0][1]+s[0][2];
        int h1 = s[1][0]+s[1][1]+s[1][2];
        int h2 = s[2][0]+s[2][1]+s[2][2];

        int v0 = s[0][0]+s[1][0]+s[2][0];
        int v1 = s[0][1]+s[1][1]+s[2][1];
        int v2 = s[0][2]+s[1][2]+s[2][2];

        int d1 = s[0][0]+s[1][1]+s[2][2];
        int d2 = s[0][2]+s[1][1]+s[2][0];

        return h0==h1 && h1==h2 && h2 == v0 && v0==v1 && v1==v2 && v2 ==d1 && d1 == d2;
    }

    public static int getSolution(int[][] s) {

        int result = Integer.MAX_VALUE;
        if(isMagic(s)){
            result = 0;
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int current = s[i][j];
                    for(int x =1;x<=9;x++){
                        s[i][j]=x;
                        if(isMagic(s)){
                            int aux = Math.abs(current-x);
                            if(aux<result){
                                result = aux;
                            }
                            if(result==1){
                                return 1;
                            }
                        }

                    }
                    s[i][j]=current;
                }
            }
        }

        return result;
    }
}

