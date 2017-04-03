package es.avernostudios.angryProfessor;

import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        try {
            if (args.length > 0) {
                scanner = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int t = scanner.nextInt();
        for(int i =0;i<t;i++){
            int testN = scanner.nextInt();
            int testK = scanner.nextInt();

            int arrivals = 0;
            for(int n=0; n<testN;n++){
                int currentAttendantTime = scanner.nextInt();
                if(currentAttendantTime<=0){
                    arrivals ++;
                }

            }
            //System.out.println(String.format("Test[%d] : { 'N':%d,'K':%d } -> arrivals = %d ",i,testN, testK,arrivals));

            if(arrivals < testK){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}