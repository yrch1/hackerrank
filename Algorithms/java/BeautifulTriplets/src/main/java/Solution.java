import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }

        int count = getSolution(n, d, a);
        System.out.println(count);
    }

    public static int getSolution(int n, int d, int[] a) {
        int count = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(a[i]+d==a[j]){
                    for(int k=j+1;k<n;k++){
                        if( a[j]+d == a[k]){
                            count++;
                        }
                    }
                }


            }

        }
        return count;
    }
}
