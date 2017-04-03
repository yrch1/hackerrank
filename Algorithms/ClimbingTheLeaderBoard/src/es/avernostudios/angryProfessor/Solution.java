package es.avernostudios.angryProfessor;

import javafx.collections.transformation.SortedList;

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

        Set<Integer> leaderBoard = new TreeSet<>();
        for(int i=0;i<scores.length;i++){
            int currentScore = scores[i];
            if(!leaderBoard.contains(currentScore)){
                leaderBoard.add(currentScore);
            }
        }

        Integer[] temp = leaderBoard.toArray(new Integer[0]);

        for(int i =0;i<alice.length;i++){
            int currentAliceScore = alice[i];
            int x=0;
            for(int j=0;j<temp.length;j++){
                int aux = temp[j];
               if(currentAliceScore>=aux){
                   x++;
               }else{
                   System.out.println(leaderBoard.size()+1-x);
                   break;
               }
            }
            if(x==leaderBoard.size()){
                System.out.println(leaderBoard.size()+1-x);
            }
        }


    }

}

