import java.util.*;

/**
 * MinimumLoss Created by dortega on 04/05/2017.
 */
public class Solution {

    public static class MyPair implements Comparable<MyPair>{
        long index;
        long price;

        public long getIndex() {
            return index;
        }

        public void setIndex(long index) {
            this.index = index;
        }


        public MyPair(long index, long price){
            this.index = index;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            MyPair other = (MyPair) o;
            return other.price==this.price && other.index == other.index;
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         * <p>
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         * <p>
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         * <p>
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         * <p>
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         * <p>
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param o2 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        public int compareTo(MyPair o2) {
            int result = 0;
            if(this.price<o2.price){
                result = 1;
            }else if(this.price>o2.price){
                result = -1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Prlong output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[]  arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }
        System.out.println(getSolution(arr));
    }

    public static long getSolution(long arr[]){
        long n = arr.length;
        long min = Long.MAX_VALUE;
        List<MyPair> myList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            MyPair newOne = new MyPair(i,arr[i]);
            myList.add(newOne);
        }

        Collections.sort(myList);

        for(int i=0;i<n;i++){
            int current =  Collections.binarySearch(myList,new MyPair(i,arr[i]));
            if(current+1<n){
                MyPair nextOne = myList.get(current+1);
                if(nextOne.index>i){
                    long tem = arr[i] - nextOne.price;
                    if(tem>=0 && tem<min){
                        min = tem;
                    }
                }
            }
        }
        return min;
    }

}
