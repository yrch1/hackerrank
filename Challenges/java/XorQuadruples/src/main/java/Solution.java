/**
 * Created by yrch on 13/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static class Quadruple{
        private static Map<String,Integer> cache = new HashMap<>();
        private String key = new String();

        public Pair leftSide;
        public Pair rightSide;


        public Quadruple(int w, int x, int y, int z) {


            int[] arr = new int[4];
            arr[0]=w;
            arr[1]=x;
            arr[2]=y;
            arr[3]=z;

            Arrays.sort(arr);

            leftSide = new Pair(arr[0],arr[1]);
            rightSide = new Pair(arr[2],arr[3]);


            this.key = leftSide.key+"-"+this.rightSide.key;

        }

        public Quadruple(Pair p, Pair q) {
            this(p.w,p.x,q.w,q.x);
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
            return this.key + " -> " +this.getXOR();
        }


        public int getXOR(){

            int result = 0;
            Integer aux = cache.get(this.key);
            if(aux!=null){
                result = aux.intValue();
            }else{
                result = leftSide.getXOR()^rightSide.getXOR();
                this.cache.put(this.key,result);
            }
            return result;
        }

    }


    public static class Pair{

        private static Map<String,Integer> cache = new HashMap<>();

        private String key = new String();
        public int w;
        public int x;

        public Pair(int w, int x){

            this.w = w;
            this.x = x;

            int[] arr = new int[2];
            arr[0]=w;
            arr[1]=x;

            Arrays.sort(arr);

            this.key = String.format("%d-%d",arr[0],arr[1]);



        }

        public int getXOR(){
            int result = 0;
            Integer aux = cache.get(this.key);
            if(aux!=null){
                result = aux;
            }else{
                result = x^w;
                this.cache.put(this.key,x^w);
            }
            return  result;
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

        Set<Pair> set1 = calculatePair(a, b);
        Set<Pair> set2 = calculatePair(c, d);
        Set<Quadruple> mySet = new HashSet<>(set1.size()*set2.size());
        for(Pair p : set1){
            for(Pair q : set2){
                mySet.add(new Quadruple(p,q));

            }
        }

        return mySet.stream().filter(x->x.getXOR()!=0).count();
    }

    private static Set<Pair> calculatePair(int a, int b) {
        Set<Pair> result= new HashSet<>(a*b);
        for(int w = 1; w<=a; w++) {
            for (int x = 1; x <= b; x++) {

                Pair wx = new Pair(w, x);
                result.add(wx);
            }
        }
        return result;
    }


    public static long getQuadruples3(int v1, int v2, int v3, int v4) {



        Map<Pair,Long> set1 = calculatePairXor(v1, v2);
        Map<Pair,Long> set2 = calculatePairXor(v3, v4);
        Set<Quadruple> mySet = new HashSet<>();

        long count=0;
        for(Pair p : set1.keySet()){
            for(Pair q : set2.keySet()){
                if(!p.equals(q)){
                    mySet.add(new Quadruple(p.w,p.x,q.w,q.x));
                }
            }
        }
        return count;

    }

    public static Map<Pair,Long> calculatePairXor(int v1, int v2) {
        Map<Pair,Long> result = new HashMap<>();
        for(int w =1;w<=v1;w++){
            for(int x =1;x<=v2;x++){

                Pair wx = new Pair(w,x);
                if(result.containsKey(wx)){
                    result.put(wx,result.get(wx)+1);
                }else{
                    result.put(wx,1l);
                }
            }
        }
        return  result;
    }

    public static long getQuadruples2(int v1, int v2, int v3, int v4) {
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