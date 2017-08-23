/**
 * Created by yrch on 6/5/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximalTourism {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] route = new int[m][2];
        for(int route_i=0; route_i < m; route_i++){
            for(int route_j=0; route_j < 2; route_j++){
                route[route_i][route_j] = in.nextInt();
            }
        }
        System.out.println(getSolution(route));
    }

    public static long getSolution(int[][] route){
        Map<Integer,Set<Integer>> myGraph = new HashMap<>();
        for(int i=0;i<route.length;i++){
            for(int j=0;j<2;j++){
                Set<Integer> adjacents = myGraph.getOrDefault(route[i][j],new HashSet<>());
                adjacents.add(route[i][1-j]);
                myGraph.put(route[i][j],adjacents);
            }

        }

        Set<Integer> discovered = new HashSet<>();
        long max = 0;
        for(Integer root : myGraph.keySet()){
            if(!discovered.contains(root)){
                Stack<Integer> myStack = new Stack<>();
                myStack.push(root);
                long count = 0;
                while(!myStack.isEmpty()){
                    int v = myStack.pop();
                    if(!discovered.contains(v)){
                        discovered.add(v);
                        count++;
                        for(Integer adjacent : myGraph.get(v)){

                            myStack.push(adjacent);
                        }
                    }
                }
                if(count > max){
                    max = count;
                }
            }

        }
        return max;
    }


}
