/**
 * QueensAttack2 Created by dortega on 12/04/2017.
 */
import java.util.*;

public class Solution {


    public static class Cell {
        public int row;
        public int column;

        public Cell(int row, int column){
            this.row = row;
            this.column = column;
        }


        @Override
        public String toString() {
            return String.format("row[%d] - column [%d]",row, column);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Cell)) {
                return false;
            }

            Cell cell = (Cell) o;

            return this.row==cell.row && this.column == cell.column;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        List<Cell> obstacleList = new ArrayList<>(k);
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            // your code goes here
            Cell obstacle = new Cell(rObstacle,cObstacle);
            obstacleList.add(obstacle);
        }
        System.out.println(couldAttack(n,new Cell(rQueen,cQueen),obstacleList));
    }

    public static long couldAttack(int n, Cell queenPosition, List<Cell> obstacleList){

        long horizontalLeft;
        long horizontalRight;
        long verticalTop;
        long verticalBottom;
        long diagonalUpperLeft;
        long diagonalUpperRight;
        long diagonalBottomLeft;
        long diagonalBottomRight;

        horizontalLeft = getHorizontalLeft(queenPosition, obstacleList);
        horizontalRight = getHorizontalRight(n, queenPosition, obstacleList);
        verticalBottom = getVerticalBottom(queenPosition, obstacleList);
        verticalTop = getVerticalTop(n, queenPosition, obstacleList);
        diagonalUpperLeft = getDiagonalUpperLeft(n, queenPosition, obstacleList);
        diagonalUpperRight = getDiagonalUpperRight(n, queenPosition, obstacleList);
        diagonalBottomLeft = getDiagonalBottomLeft(queenPosition, obstacleList);
        diagonalBottomRight = getDiagonalBottomRight(n, queenPosition, obstacleList);


        return horizontalLeft+horizontalRight+verticalTop+verticalBottom+diagonalUpperLeft+diagonalUpperRight+diagonalBottomLeft+diagonalBottomRight;
    }

    /**
     *
     * @param n
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getDiagonalBottomRight(int n, Cell queenPosition, List<Cell> obstacleList) {
        long diagonalBottomRight = 0;
        int i;
        int j;
        i=queenPosition.row-1;
        j=queenPosition.column+1;

        while(i>0 && j<=n){
            if(!thereIsAObstacle(new Cell(i,j),obstacleList)){
                diagonalBottomRight++;
            }else{
                break;
            }
            if(i>0){
                i--;
            }
            if(j<=n) {
                j++;
            }


        }
        return diagonalBottomRight;
    }

    /**
     *
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getDiagonalBottomLeft(Cell queenPosition, List<Cell> obstacleList) {
        long diagonalBottomLeft = 0;
        int i;
        int j;//diagonal-bottom-left
        i=queenPosition.row-1;
        j=queenPosition.column-1;

        while (i > 0 && j > 0) {
            if (!thereIsAObstacle(new Cell(i, j), obstacleList)) {
                diagonalBottomLeft++;
            } else {
                break;
            }

            if (i > 0) {
                i--;
            }
            if (j > 0) {
                j--;
            }


        }
        return diagonalBottomLeft;
    }

    /**
     *
     * @param n
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getDiagonalUpperRight(int n, Cell queenPosition, List<Cell> obstacleList) {
        long diagonalUpperRight = 0;
        int i;
        int j;//diagonal-upper-right
        i=queenPosition.row+1;
        j=queenPosition.column+1;

        while(i<=n && j<=n){
            if(!thereIsAObstacle(new Cell(i,j),obstacleList)){
                diagonalUpperRight++;
            }else{
                break;
            }

            if(i<=n){
                i++;
            }
            if(j<=n) {
                j++;
            }


        }
        return diagonalUpperRight;
    }

    /**
     *
     * @param n
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getDiagonalUpperLeft(int n, Cell queenPosition, List<Cell> obstacleList) {
        long diagonalUpperLeft = 0;
        int i=queenPosition.row+1,j=queenPosition.column-1;

        while( i<=n && j>0){
            if(!thereIsAObstacle(new Cell(i,j),obstacleList)){
                diagonalUpperLeft++;
            }else{
                break;
            }

            if(i<=n){
                i++;
            }
            if(j>0) {
                j--;
            }

        }
        return diagonalUpperLeft;
    }

    /**
     *
     * @param n
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getVerticalTop(int n, Cell queenPosition, List<Cell> obstacleList) {
        long verticalTop = 0;
        //verticalTop
        for(int i=queenPosition.row+1;i<=n;i++){
            if(!thereIsAObstacle(new Cell(i,queenPosition.column),obstacleList)){
                verticalTop++;
            }else{
                break;
            }
        }
        return verticalTop;
    }

    /**
     *
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getVerticalBottom(Cell queenPosition, List<Cell> obstacleList) {
        long verticalBottom = 0;
        //verticalBottom
        for(int i=queenPosition.row-1;i>0;i--){
            if(!thereIsAObstacle(new Cell(i,queenPosition.column),obstacleList)){
                verticalBottom++;
            }else{
                break;
            }
        }
        return verticalBottom;
    }

    /**
     *
     * @param n
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getHorizontalRight(int n, Cell queenPosition, List<Cell> obstacleList) {
        long horizontalRight = 0;
        //horizontalRight
        for(int i=queenPosition.column+1;i<=n;i++){
            if(!thereIsAObstacle(new Cell(queenPosition.row,i),obstacleList)){
                horizontalRight++;
            }else{
                break;
            }
        }
        return horizontalRight;
    }

    /**
     *
     * @param queenPosition
     * @param obstacleList
     * @return
     */
    public static long getHorizontalLeft(Cell queenPosition, List<Cell> obstacleList) {
        long horizontalLeft = 0;
        //horizontalLeft
        for(int i=queenPosition.column-1;i>0;i--){
            if(!thereIsAObstacle(new Cell(queenPosition.row,i),obstacleList)){
                horizontalLeft++;
            }else{
                break;
            }
        }
        return horizontalLeft;
    }

    private static boolean thereIsAObstacle(Cell cell,List<Cell> obstacleList) {
        return obstacleList.contains(cell);
    }
}