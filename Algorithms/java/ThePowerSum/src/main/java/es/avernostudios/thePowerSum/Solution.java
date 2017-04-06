package es.avernostudios.thePowerSum;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dortega on 06/04/2017.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(countWays(x,n));
    }

    public static int countWays(int x, int n){
       return countWaysInternal(x,n,1);
    }

    public static int countWaysInternal(int x,int n,int minInt){
        int result = 0;
        if(x==0){
            result = 1;
        }else if(minInt>x){
            result = 0;
        }else {
            if (x == 1) {
                result = 1;
            } else {
                for (int i = minInt; i <= x; i++) {
                    int partial = (int) Math.pow(i, n);
                    if (x - partial >= 0) {
                        result += countWaysInternal(x - partial, n, i + 1);
                    }
                }
            }
        }
        return result;
    }
}
