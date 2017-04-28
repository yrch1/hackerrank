import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(getSolution(n));
        }


    }


    public static long getSolution2(int n){
        int x3 = n/3;
        int x5 = n/5;
        int x15 = n/15;

        long sum1 = 3*x3*(x3+1);
        long sum2 = 5*x5*(x5+1);
        long sum3 = 15*x15*(x15+1);

        long sum = (sum1+sum2-sum3)/2;
        return sum;
    }

    public static long getSolution(int n){
        long result = sumOfMultipleOf(n,3)+ sumOfMultipleOf(n,5)- sumOfMultipleOf(n,15);

        return result/2;
    }

    public static long sumOfMultipleOf(int n, int k) {

        int limit = (n-1) / k;

        return k*limit*(limit+1);
    }
}
