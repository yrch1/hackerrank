/**
 * Created by yrch on 13/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static class Quadruple{

        private String key = new String();
        public int w;
        public int x;
        public int y;
        public int z;

        public Quadruple(int w, int x, int y, int z){

            this.w = w;
            this.x = x;
            this.y = y;
            this.z = z;

            int[] arr = new int[4];
            arr[0]=w;
            arr[1]=x;
            arr[2]=y;
            arr[3]=z;

            Arrays.sort(arr);


/*
            SortedMap<Integer,Long> temp = new TreeMap<>();
            temp.put(w,1l);
            if(temp.containsKey(x)){
                temp.put(x,temp.get(x)+1l);
            }else{
                temp.put(x,1l);
            }
            if(temp.containsKey(y)){
                temp.put(y,temp.get(y)+1l);
            }else{
                temp.put(y,1l);
            }
            if(temp.containsKey(z)){
                temp.put(z,temp.get(z)+1l);
            }else{
                temp.put(z,1l);
            }

            StringBuilder aux = new StringBuilder();
            for(Integer key : temp.keySet()){
                aux.append(key+"-"+temp.get(key));
            }
*/

            this.key = String.format("%d-%d-%d-%d",arr[0],arr[1],arr[2],arr[3]);
            //temp.keySet().stream().forEach(e-> key+=String.format("%d-%d-",e,temp.get(e)));
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Quadruple)) {
                return false;
            }

            Quadruple item = (Quadruple) o;
            boolean result = this.key.length()==item.key.length() && this.key.equals(item.key);
            return result;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result + this.key.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return this.key;
        }
    }


    public static class Pair{

        private String key = new String();
        public int w;
        public int x;
        public int y;
        public int z;

        public Pair(int w, int x){

            this.w = w;
            this.x = x;

            int[] arr = new int[2];
            arr[0]=w;
            arr[1]=x;

            Arrays.sort(arr);

            this.key = String.format("%d-%d",arr[0],arr[1]);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Pair)) {
                return false;
            }

            Pair item = (Pair) o;
            boolean result = this.key.length()==item.key.length() && this.key.equals(item.key);
            return result;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result + this.key.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return this.key;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        long count = getQuadruples(a, b, c, d);
        System.out.println(count);

    }

    public static long getQuadruples(int v1, int v2, int v3, int v4) {
        Set<Quadruple> visited = new HashSet<>();
        Map<Pair,Integer> cache = new HashMap<>();
        long count = 0;

        int[] arr = new int[4];
        arr[0]=v1;
        arr[1]=v2;
        arr[2]=v3;
        arr[3]=v4;

        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];

        for(int w =1;w<=a;w++){

            for(int x =1;x<=b;x++){
                int wx;
                if(w!=x){
                    Pair pair = new Pair(w, x);
                    Integer aux1 = cache.get(pair);
                    if(aux1!=null){
                        wx = aux1;
                    }else{
                        wx = w ^ x;
                        cache.put(pair,wx);
                    }
                }else{
                    wx = 0;
                }

                for(int y =1;y<=c;y++){
                    int wxy;
                    if(wx != y){
                        if(wx!=0){

                            Pair pair = new Pair(wx, y);
                            Integer aux1 = cache.get(pair);
                            if(aux1!=null){
                                wxy = aux1;
                            }else{
                                wxy= wx ^ y;
                                cache.put(pair,wxy);
                            }

                        }else{
                            wxy = y;
                        }
                    }else{
                        wxy = 0;
                    }

                    for(int z =1;z<=d;z++){
//                        System.out.println(String.format("%d,%d,%d,%d",w,x,y,z));
                        Quadruple newOne = new Quadruple(w,x,y,z);
                        if(!visited.contains(newOne)){
                            if(wxy != z){
                                count++;
                            }
                            visited.add(newOne);
                        }
                    }
                }
            }
        }
        return count;
    }
}