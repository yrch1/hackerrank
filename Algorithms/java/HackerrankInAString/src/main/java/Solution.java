/**
 * HackerrankInAString Created by dortega on 23/05/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean getSolution(String base,String s){
        boolean result = false;
        //System.out.println(String.format("Probando con %s en %s",base,s));
        if(base.length()>1){
            char current = base.charAt(0);
            int position = s.indexOf(current);
            // System.out.println(String.format("la posicion de %c es %d",current,position));
            if(position>=0){
                result = getSolution(base.substring(1),s.substring(position+1));
            }
        }else{
            char current = base.charAt(0);
            int position = s.indexOf(current);
            result = position>=0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            if(getSolution("hackerrank",s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}