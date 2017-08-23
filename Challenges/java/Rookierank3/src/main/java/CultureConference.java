/**
 * Created by yrch on 6/5/17.
 */
import java.io.File;
import java.util.*;

public class CultureConference {



    public static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> preOrder, List<Integer> postOrder) {
        // This is the first visit of this node, therefore add it to Pre-Order ordering
        preOrder.add(node);

        // Add this node to the visited nodes' list
        visited.add(node);

        // Process the adjacent nodes of this node
        if(graph.containsKey(node)){
            for (Integer adjacent : graph.get(node)) {
                if (!visited.contains(adjacent)) {
                    // If the adjacent node is not already visited, then call dfs() on this adjacent node recursively
                    dfs(adjacent, graph, visited, preOrder, postOrder);
                }
            }
        }

        // This is the last visit of this node, therefore add it to the Post-Order ordering
        postOrder.add(node);
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
        Set<Integer> burnedOut = new HashSet<>();

        // Information for employees 1 through n - 1:
        // The first value is the employee's supervisor ID
        // The second value is the employee's burnout status (0 is burned out, 1 is not)
        Map<Integer,List<Integer>> myGraph = new HashMap<>();
        for(int e_i=0; e_i < n-1; e_i++){
            int nodeId = e_i+1;
            int supervisor = in.nextInt();
            boolean isBurned = in.nextInt()==0;
            supervisors[nodeId]=supervisor;

            if(isBurned){
                burnedOut.add(nodeId);
            }

            List<Integer> adjacents = myGraph.getOrDefault(supervisor,new ArrayList<>());

            adjacents.add(nodeId);
            myGraph.put(supervisor,adjacents);
        }




        //Set to maintain visited node's
        Set<Integer> visited = new HashSet<>();

        //Node to start the dfs traversal
        int startNode = 0;

        // This list will maintain the Pre-Order ordering
        List<Integer> preOrder = new ArrayList<>();

        // This list will maintain the Post-Order ordering
        List<Integer> postOrder = new ArrayList<>();

        //Call dfs
        dfs(startNode, myGraph, visited, preOrder, postOrder);


        //System.out.println("Post-Order ordering - " + postOrder);

        int minimumEmployees = getMinimumEmployees(postOrder,myGraph,burnedOut,supervisors);
        System.out.println(minimumEmployees);
    }

    static int getMinimumEmployees(List<Integer> path,Map<Integer,List<Integer>> myGraph,Set<Integer> burnedOut,int[] supervisors){
        int count = 0;
        for(Integer node: path){
            if(!burnedOut.isEmpty()) {
                if (burnedOut.contains(node)) {
                    burnedOut.remove(node);
                    burnedOut.remove(supervisors[node]);
                    burnedOut.remove(supervisors[supervisors[node]]);
                    for (Integer sibling : myGraph.get(supervisors[node])) {
                        burnedOut.remove(sibling);
                    }
                    count++;
                }
            }
        }
        return count;
    }

}
