/**
 * Created by yrch on 13/4/17.
 */
import java.util.*;

public class Solution {

    public static class Quadruple{
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
            leftSide = p;
            rightSide = q;
            this.key = leftSide.key+"-"+this.rightSide.key;
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
            return this.key + " -> " + " " +this.getXOR();
        }


        public int getXOR(){

            int result = 0;
                result = leftSide.getXOR()^rightSide.getXOR();

            return result;
        }

    }


    public static class Pair{

        private static Map<String,Integer> cache = new HashMap<>();

        private String key = new String();
        public int w;
        public int x;

        public Pair(int w, int x){

            if(w<=x){
                this.w = w;
                this.x = x;


                this.key = String.format("%d-%d",w,x);
            }else{
                this.w = x;
                this.x = w;


                this.key = String.format("%d-%d",x,w);
            }
        }

        public int getXOR(){
            int result = 0;
            Integer aux = cache.get(this.key);
            if(aux!=null){
                result = aux;
            }else{
                if(x==w){
                    result = 0;
                }else{
                    if(x==0){
                        result = w;
                    }else{
                        if(w==0){
                            result = x;
                        }else{
                            result = x^w;
                        }
                    }
                }
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
        Set<Quadruple> visited = new HashSet<>();
        long count=0;

        Set<Pair> smallSet = set1;
        Set<Pair> bigSet = set2;
        if(set1.size()>set2.size()){
            smallSet = set2;
            bigSet = set1;
        }

        for(Pair p : smallSet){
            int pxor = p.getXOR();
            for(Pair q : bigSet){
                if(p.x<=q.w){
                    Quadruple myQuadruple = new Quadruple(p,q);
                    if(!visited.contains(myQuadruple)){
                        if(q.getXOR()!=pxor){
                            count++;
                        }
                        visited.add(myQuadruple);
                    }
                }
            }
        }

        return count;
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


}