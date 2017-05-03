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

    public static long getSolution(int n){
        long result = sumOfMultipleOf(n,3)+ sumOfMultipleOf(n,5)- sumOfMultipleOf(n,15);

        return result/2;
    }

    public static long sumOfMultipleOf(int n, int k) {

        long limit = (n-1) / k;

        return k*limit*(limit+1);
    }
}
