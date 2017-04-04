package es.avernostudios.climbingTheLeaderboard;

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
            System.out.println(getRankPosition(temp,currentAliceScore));
        }
    }

    public static int getRankPosition(Integer[] intArray, int toFind){
        return 1+intArray.length - scoresLowerThanCertain(intArray,0,intArray.length-1,toFind) ;
    }

    public static int scoresLowerThanCertain(Integer[] intArray, int lo, int hi, int toFind){
        int result = -1000;
        if(hi-lo>=0){
            if(lo<hi){
                int mid = lo + (hi - lo) / 2;
                if(intArray[mid].intValue() == toFind){
                    result =  mid-lo+1;
                }else if(toFind<intArray[mid].intValue()){
                    result =  scoresLowerThanCertain(intArray,lo,mid-1,toFind);
                }else{
                    result =  mid -lo +1 + scoresLowerThanCertain(intArray,mid+1,hi,toFind);
                }
            }else if(lo==hi){
                if(toFind>=intArray[lo]){
                    result =  1;
                }else{
                    result =  0;
                }
            }
        }else{
            result =  0;
        }
        return result;
    }

}

