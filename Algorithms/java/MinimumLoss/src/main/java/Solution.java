import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * MinimumLoss Created by dortega on 04/05/2017.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]  arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.print(getSolution(arr));
    }

    public static int getSolution(int arr[]){
        int min = Integer.MAX_VALUE;
        List<Integer> visited = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(!visited.contains(arr[i])){
                visited.add(arr[i]);
                for(int j=i+1;j<arr.length;j++) {
                    int current = arr[i] - arr[j];
                    if (current > 0 && current < min) {
                        min = current;
                    }
                }
            }


        }
        return min;
    }
}
