/**
 * Created by yrch on 25/4/17.
 */
import java.util.*;

public class Solution {

    public  static  class Cell{
        private int x;
        private int y;

        public Cell(){

        }

        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", getX(), getY());
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean isValid(Cell target) {
            return this.getX()>=0 && this.getY()>=0 && this.getX() <= target.getX() && this.getY()<= target.getY();
        }

        @Override
        public int hashCode() {
            return x*2+y*9;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Cell)) {
                return false;
            }

            Cell other = (Cell) o;

            return other.getX()==this.getX()&& other.getY()==this.getY();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
        for(int i=n-1;i>0;i--){
            String  s = Solution.getSolution(i,new Cell(i,i));
        }
    }

    private static String getSolution(int x, Cell target) {
        StringBuilder result = new StringBuilder();
        for(int i = 1;i<x;i++){

            boolean visited[][]  = initVisited(x+1);

            long movements = getMovements(new Cell(0,0),target,1,i,visited);
            result.append(movements+" ");
        }

        return null;
    }

    private static long getMovements(Cell source, Cell target, int i, int j, boolean[][] visited) {
        long result = 0;
        if(source.equals(target)){
            result = 0;
        }else{
            if(!visited[source.getX()][source.getY()]){
                visited[source.getX()][source.getY()] = true;
                List<Cell> movements = getPossibleMovements(source,i,j,target);
                long min  = Long.MAX_VALUE;
                for(Cell nextMovement : movements){
                    boolean[][] visited2 = visited.clone();
                    long current = getMovements(nextMovement,target,i,j,visited2);
                    if(current!=-1 && current !=Long.MAX_VALUE){
                        current++;
                        if(current<min){
                            min = current;
                        }
                    }

                }

            }else{
                result = -1;
            }
        }



        return result;
    }

    private static boolean[][] initVisited(int x) {
        boolean[][] result = new boolean[x][x];

       for(int i=0;i<x;i++){
           result[i] = new boolean[x];
           for(int j=0;j<x;j++){
               result[i][j]=false;
           }
       }

       return result;
    }


    public static long getDistance(Cell a, Cell b){
        int ni = Math.abs(b.getX()-a.getX());
        int mj = Math.abs(b.getY()-a.getY());
        return ni>mj?ni:mj;
    }

    public static List<Cell> getPossibleMovements(Cell s, int a, int b, Cell target) {
        List<Cell>  result = new ArrayList<>();

        Cell c1 =  new Cell(s.getX()+a,s.getY()+b);
        Cell c2 =  new Cell(s.getX()+b,s.getY()+a);
        Cell c3 =  new Cell(s.getX()+a,s.getY()-b);
        Cell c4 =  new Cell(s.getX()+b,s.getY()-a);

        Cell c5 =  new Cell(s.getX()-a,s.getY()+b);
        Cell c6 =  new Cell(s.getX()-b,s.getY()+a);
        Cell c7 =  new Cell(s.getX()-a,s.getY()-b);
        Cell c8 =  new Cell(s.getX()-b,s.getY()-a);

        if(c2.isValid(target) && !result.contains(c2)){
            result.add(c2);
        }

        if(c1.isValid(target) && !result.contains(c1)){
            result.add(c1);
        }



        if(c3.isValid(target) && !result.contains(c3)){
            result.add(c3);
        }

        if(c4.isValid(target) && !result.contains(c4)){
            result.add(c4);
        }

        if(c5.isValid(target) && !result.contains(c5)){
            result.add(c5);
        }

        if(c6.isValid(target) && !result.contains(c6)){
            result.add(c6);
        }

        if(c7.isValid(target) && !result.contains(c7)){
            result.add(c7);
        }

        if(c8.isValid(target) && !result.contains(c8)){
            result.add(c8);
        }


        Collections.sort(result,new MyComparator(target));


        return result;
    }

    private static class MyComparator implements Comparator<Cell> {
        private Cell target;
        public MyComparator(Cell target) {
            this.target = target;
        }

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.<p>
         * <p>
         * The implementor must ensure that <tt>sgn(compare(x, y)) ==
         * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>compare(x, y)</tt> must throw an exception if and only
         * if <tt>compare(y, x)</tt> throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
         * <tt>compare(x, z)&gt;0</tt>.<p>
         * <p>
         * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
         * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
         * <tt>z</tt>.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Cell o1, Cell o2) {
            long d1 = Solution.getDistance(o1,target);
            long d2 = Solution.getDistance(o2,target);
            if(d1>d2){
                return 1;
            }else if(d1==d2){
                return 0;
            }else{
                return  -1;
            }
        }
    }
}
