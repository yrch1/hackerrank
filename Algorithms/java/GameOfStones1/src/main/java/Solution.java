/**
 * Created by yrch on 22/4/17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public enum Players{
        First("First"),Second("Second");

        private final String name;

        Players(String s) {
            name = s;
        }

        public String toString() {
            return this.name;
        }

        public Players togglePlayer(){
            if(this.equals(First)){
                return Players.Second;
            }else{
                return Players.First;
            }
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCount = in.nextInt();
        for(int i=0;i<testCount;i++){
            System.out.println(whoWins(in.nextInt(),Players.First));
        }

    }

    public static Players whoWins(int stones,Players currentPlayer){
        Players winner = currentPlayer;
        if(stones%7<2){
            winner = currentPlayer.togglePlayer();
        }


        return winner;
    }
}