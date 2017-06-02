/**
 * FunnyString Created by dortega on 18/05/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] testCases = new String[n];
        for(int i=0;i<n;i++){
            testCases[i] = in.next();
            if(getSolution(testCases[i])==true ){
                System.out.println("Funny");
            }else {
                System.out.println("Not Funny");
            }
        }

        in.close();
    }

    public static boolean getSolution(String testCase) {
        boolean result = true;
        for(int i=1;i<testCase.length();i++){
            int left = testCase.charAt(i)-testCase.charAt(i-1);
            int right = testCase.charAt(testCase.length()-i-1)-testCase.charAt(testCase.length()-i);
            if(Math.abs(left)!=Math.abs(right)){
                result = false;
                break;
            }
        }

        return result;
    }
}