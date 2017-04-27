import java.util.*;

/**
 * knightl-on-chessboard Created by dortega on 27/04/2017.
 */
public class Solution {

    public  static  class Cell{
        private int x;
        private int y;

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

        String  s = Solution.getSolution(n);
        System.out.println(s);

    }

    private static String getSolution(int n) {
        StringBuilder result = new StringBuilder();
        Map<String,Long> symmetricCache = new HashMap<>();
        for(int i=1;i<n;i++){
            for(int j = 1;j<n;j++){
                long movements;
                if(!symmetricCache.containsKey(i+"-"+j) && !symmetricCache.containsKey(j+"-"+i)){
                    movements = BFS(new Cell(0,0),new Cell(n-1,n-1),n,i,j);
                    symmetricCache.put(j+"-"+i,movements);
                }else{
                    if(symmetricCache.containsKey(i+"-"+j)){
                        movements = symmetricCache.get(i+"-"+j);
                    }else{
                        movements = symmetricCache.get(j+"-"+i);
                    }
                }
                result.append(movements+" ");
            }
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }

    public  static int BFS(Cell source, Cell target, int n, int a, int b) {
        return BFS(source,target,n,a,b,false);
    }

    public  static int BFS(Cell source, Cell target, int n, int a, int b, boolean isSandBox){

        Map<Cell,Integer> distance = new HashMap<>();
        distance.put(source,0);
        Queue<Cell> queue = new LinkedList<>();
        queue.add(source);
        if(isSandBox) {
            System.out.println(source);
        }
        while (!queue.isEmpty()) {
            Cell node = queue.remove();
            if(!node.equals(target)){
                Integer nodeDistance = distance.get(node);
                if(isSandBox){
                    System.out.print("\n"+node+"  -> ");
                }

                List<Cell> possibleMovements =  getPossibleMovements(node,a,b,target,distance.keySet());
                for(Cell child : possibleMovements){
                    distance.put(child,nodeDistance+1);
                    if(isSandBox) {
                        System.out.print(child +" ");
                    }
                    queue.add(child);
                }
            }else{
                break;
            }


        }

        return distance.getOrDefault(target,-1);
    }

    public static List<Cell> getPossibleMovements(Cell s, int a, int b, Cell target, Set<Cell> visited) {
        List<Cell>  result = new ArrayList<>();

        Cell c1 =  new Cell(s.getX()+a,s.getY()+b);
        Cell c2 =  new Cell(s.getX()+b,s.getY()+a);
        Cell c3 =  new Cell(s.getX()+a,s.getY()-b);
        Cell c4 =  new Cell(s.getX()+b,s.getY()-a);

        Cell c5 =  new Cell(s.getX()-a,s.getY()+b);
        Cell c6 =  new Cell(s.getX()-b,s.getY()+a);
        Cell c7 =  new Cell(s.getX()-a,s.getY()-b);
        Cell c8 =  new Cell(s.getX()-b,s.getY()-a);



        if(c1.isValid(target) && !result.contains(c1) && !visited.contains(c1)){
            result.add(c1);
        }

        if(c2.isValid(target) && !result.contains(c2) && !visited.contains(c2)){
            result.add(c2);
        }

        if(c3.isValid(target) && !result.contains(c3) && !visited.contains(c3)){
            result.add(c3);
        }

        if(c4.isValid(target) && !result.contains(c4) && !visited.contains(c4)){
            result.add(c4);
        }

        if(c5.isValid(target) && !result.contains(c5) && !visited.contains(c5)){
            result.add(c5);
        }

        if(c6.isValid(target) && !result.contains(c6) && !visited.contains(c6)){
            result.add(c6);
        }

        if(c7.isValid(target) && !result.contains(c7) && !visited.contains(c7)){
            result.add(c7);
        }

        if(c8.isValid(target) && !result.contains(c8) && !visited.contains(c8)){
            result.add(c8);
        }

        return result;
    }

}
