import java.util.*;

/**
 * Holidays Created by dortega on 20/04/2017.
 */
public class Solution {

    public static int getSolutionSlow3(int[] A) {
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
                for(int j=i+1;j<places.size();j++){
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
        Set<Integer> places = new HashSet<>();
        int lastChange = -1;
        for(int i=0;i<a.length;i++){
            if(!places.contains(a[i])){
                places.add(a[i]);
                lastChange=i;
            }

        }

        Map<Integer,Integer> places2 = new HashMap<>();

        for(int i=0;i<a.length;i++){
            places2.put(a[i],i);
        }

        int start = a.length,end = lastChange;
        for(Integer item : places2.values() ){
            if(item<start){
                start = item;
            }
            if(item>end){
                end = item;
            }
        }
        return end-start+1;
/*
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
        */
    }
}
