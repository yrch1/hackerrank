import java.io.File;
import java.util.*;

/**
 * Created by yrch on 5/5/17.
 */
public class Solution3 {

    public static class MyPair implements Comparable<MyPair>{
        int index;
        int count;

        public MyPair(int index, int count){
            this.index = index;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            MyPair other = (MyPair) o;
            return other.count ==this.count && other.index == other.index;
        }

        @Override
        public int compareTo(MyPair o2) {
            int result = 0;
            if(this.count <o2.count){
                result = 1;
            }else if(this.count >o2.count){
                result = -1;
            }else{
                if(this.index<o2.index){
                    result = 1;
                }else if(this.index>o2.index){
                    result = -1;
                }
            }
            return result;
        }
    }


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
        int[] supervisors = new int[n];



        Set<Integer> burned = new HashSet<>();

        // Information for employees 1 through n - 1:
        // The first value is the employee's supervisor ID
        // The second value is the employee's burnout status (0 is burned out, 1 is not)
        Map<Integer,List<Integer>> myGraph = new HashMap<>();
        for(int e_i=0; e_i < n-1; e_i++){
            int nodeId = e_i+1;
            int supervisor = in.nextInt();
            boolean isBurnedOut = in.nextInt()==0;

            if(isBurnedOut){
                burned.add(nodeId);
            }

            supervisors[nodeId]=supervisor;

            List<Integer> adjacents = myGraph.getOrDefault(supervisor,new ArrayList<>());

            adjacents.add(nodeId);
            myGraph.put(supervisor,adjacents);
        }




        int minimumEmployees = getSolution(n,myGraph,burned,supervisors);
        System.out.println(minimumEmployees);
    }

    private static MyPair[] getCandidates(int n,Map<Integer, List<Integer>> myGraph, Set<Integer> burned) {



        MyPair[] myValues = new MyPair[n];



        for(int nodeId = 0;nodeId<n;nodeId++){
            MyPair newOne = myValues[nodeId];
            if(newOne ==null){
                newOne = new MyPair(nodeId,0);
                myValues[nodeId] = newOne;
            }


            boolean isBurned = burned.contains(nodeId);
            if(isBurned){
                newOne.count++;
            }
            //aumento mis hijos
            if(myGraph.containsKey(nodeId)) {
                for (Integer adjacent : myGraph.get(nodeId)) {
                    if (burned.contains(adjacent)) {
                        newOne.count++;
                    }
                    if (isBurned) {
                        MyPair child = myValues[adjacent];
                        if(child ==null){
                            child = new MyPair(adjacent,0);
                            myValues[adjacent] = child;
                        }
                        child.count++;

                    }
                }
            }
        }
        Arrays.sort(myValues);

        return  myValues;


    }

    private static int getSolution(int n,Map<Integer, List<Integer>> myGraph, Set<Integer> burned, int[] supervisors) {

        int result = 0;
        int i =0;

        MyPair[] myValues =  getCandidates(n,myGraph,burned);
        while(!burned.isEmpty()){
            MyPair current = myValues[i++];
            boolean hasRemoved = false;
            //se elimina el actual
            if(burned.contains(current.index)||burned.contains(supervisors[current.index])){
                burned.remove(current.index);
                burned.remove(supervisors[current.index]);
                hasRemoved = true;
            }

            if(myGraph.containsKey(current.index)){
                for(Integer adjacent : myGraph.get(current.index)){
                    if(burned.contains(adjacent)) {
                        burned.remove(adjacent);
                        hasRemoved = true;
                    }
                }
            }

            if(hasRemoved){
                result++;
            }


        }

        return result;


    }

}
