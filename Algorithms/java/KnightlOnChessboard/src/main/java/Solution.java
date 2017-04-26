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
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
    }

    public static long getDistance(Cell a, Cell b){
        int ni = Math.abs(b.getX()-a.getX());
        int mj = Math.abs(b.getY()-a.getY());
        return ni>mj?ni:mj;
    }

    public static Set<Cell> getMovements(Cell s,int a, int b) {
        return new TreeSet<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return 0;
            }
        });

    }

}
