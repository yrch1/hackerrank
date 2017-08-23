/**
 * Created by yrch on 9/7/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    static int pairs(int[] a,int k) {
      /* Complete this function */
        Arrays.sort(a);

        int count = 0;


        for(int firstIndex = 0;firstIndex < a.length-1; firstIndex++){
            for(int secondIndex=firstIndex+1;secondIndex < a.length;secondIndex++ ){
                int diff = a[secondIndex]-a[firstIndex];
                if(diff==k){
                    count++;
                    break;
                }else if (diff>k){
                    break;
                }
            }
        }



        return count;
    }

    public static void main(String[] args) {
        int[] aux = {1,5,3,4,2};
        pairs(aux,2);
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a,_k);
        System.out.println(res);
    }
}