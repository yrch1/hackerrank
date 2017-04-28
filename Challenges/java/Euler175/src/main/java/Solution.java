import java.util.*;

/**
 * Euler175 Created by dortega on 28/04/2017.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SolutionFull. */
        Scanner in =  new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        System.out.println(getSolution(p,q));
    }


    public static String getSolution(long p, long q){

        Deque<Long> answer = new ArrayDeque<>();

        while (q != 0) {
            if (p > q) {
                answer.addFirst(p / q - (p % q == 0 ? 1 : 0));
                p = p % q == 0 ? q : p % q;
            } else {
                answer.addFirst(q / p);
                q %= p;
            }
        }

        StringBuilder result = new StringBuilder();

        for(Long item : answer){
            result.append(item + ",");
        }


        return  result.deleteCharAt(result.length()-1).toString();

    }

}
