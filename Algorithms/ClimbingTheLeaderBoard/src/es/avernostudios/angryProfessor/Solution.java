package es.avernostudios.angryProfessor;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }





        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here

        Map<Integer, Integer> leaderBoard = new TreeMap<>();
        for(int i=0;i<scores.length;i++){
            int currentScore = scores[i];
            if(leaderBoard.containsKey(currentScore)){
                leaderBoard.put(currentScore,leaderBoard.get(currentScore)+1);
            }else{
                leaderBoard.put(currentScore,1);
            }
        }

        for(int i =0;i<alice.length;i++){
            int currentAliceScore = alice[i];
            long scoresBiggerThanAlices = leaderBoard.keySet().stream().filter(actual -> actual>currentAliceScore).count();
            System.out.println(scoresBiggerThanAlices+1);
        }

    }

}

