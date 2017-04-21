/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */

import java.io.File;
import java.math.BigInteger;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SolutionSlow. */
        Scanner in = new Scanner(System.in);

        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        Map<Integer,Map<Integer,Integer>> myRowNodes = new HashMap<>();

        for(int i=1;i<=k;i++){
            int r = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();

            if(!myRowNodes.containsKey(r)){
                myRowNodes.put(r,null);
            }

            //Init map for the row
            Map<Integer,Integer> myColumnsNodes=myRowNodes.get(r);
            if(myColumnsNodes==null){
                myColumnsNodes = new TreeMap<>();
                myRowNodes.put(r,myColumnsNodes);
            }

            //If row contains myColumnsNodes interval begining, then merge
            if(myColumnsNodes.containsKey(c1)){
                if(myColumnsNodes.get(c1)<c2){
                    myColumnsNodes.remove(c1);
                    myColumnsNodes.put(c1,c2);
                }
            }else{
                if(myColumnsNodes.size()>0){
                    //Check overlap
                    myColumnsNodes.put(c1,c2);

                    removeOverlap(myColumnsNodes);


                }else{
                    myColumnsNodes.put(c1,c2);
                }

            }

        }

        BigInteger bigCount = new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(m)));
        for(Map<Integer,Integer> myColumnsNode : myRowNodes.values()){
            for(Integer start : myColumnsNode.keySet()){
                bigCount=bigCount.subtract(new BigInteger(String.valueOf(myColumnsNode.get(start)-start+1)));
            }
        }

        System.out.println(bigCount);
    }

    public static void removeOverlap(Map<Integer, Integer> myColumnsNodes) {

        Integer[] arr = myColumnsNodes.keySet().toArray(new Integer[myColumnsNodes.size()]);
        int currentOne = arr[0];
        for(int i=1;i<arr.length;i++){
            int other = arr[i];
            int currentOneEnd = myColumnsNodes.get(currentOne);
            if(other<=currentOneEnd){
                int otherEnd = myColumnsNodes.get(other);
                myColumnsNodes.remove(other);
                if(otherEnd>currentOneEnd) {
                    myColumnsNodes.put(currentOne, otherEnd);
                }
            }else{
                currentOne = other;
            }
        }
    }

}