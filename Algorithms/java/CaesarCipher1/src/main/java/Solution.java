/**
 * CaesarCipher1 Created by dortega on 17/05/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static String getSolution(String plainText, int offset){
        offset=offset%26;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++){
            char currentChar = plainText.charAt(i);
            if(isALetter(currentChar)){
                int num = 0;
                if(currentChar >= 'A' && currentChar <= 'Z')
                {
                    num = (int)currentChar + offset;
                    if(num>90){
                        num=64+num-90;
                    }
                }
                if(currentChar >= 'a' && currentChar <= 'z')
                {
                    num = (int)currentChar + offset;
                    if(num>122){
                        num=96+num-122;
                    }

                }
                result.append((char)num);
            }else{
                result.append(currentChar);
            }


        }
        return result.toString();
    }

    public static boolean isALetter(char current) {
        return (current>=65 && current<=90) ||(current>=97 && current<=122);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String plainText = in.next();
        int k = in.nextInt();

        String result = getSolution(plainText,k);

        System.out.print(result);

        in.close();
    }
}