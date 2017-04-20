import java.util.HashSet;
import java.util.Set;

/**
 * Holidays Created by dortega on 20/04/2017.
 */
public class Solution {

    public static int getSolutionSlow(int[] A) {
        // write your code in Java SE 8
        Set<Integer> places = new HashSet<>();
        for(int i=0;i<A.length;i++){
            places.add(A[i]);
        }
        int max = A.length;
        for(int i=0;i<A.length-1;i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(A[i]);
            if(visited.size()!=places.size()){
                for(int j=i+1;j<A.length;j++){
                    visited.add(A[j]);
                    if(visited.size()==places.size()){
                        if(j-i<max){
                            max = j-i;
                            break;
                        }
                    }
                }
            }else{
                max =0;
            }
        }
        return max+1;
    }


    public static int getSolution(int a[]) {
        int start = 0, end = start + 1;
        Set<Integer> dest = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[start] == a[i] && i != 0) {
                start++;
                end = start + 1;

            } else {
                if (!dest.contains(a[i])) {
                    end = i;
                }
            }
            dest.add(a[i]);
        }
        return end - start + 1;
    }
}
