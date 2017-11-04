import java.io.File;
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

        int t = in.nextInt();

        for(int i=0;i<t;i++){

            int n = in.nextInt();
            List<String> userPass = new ArrayList<>();

            for(int j=0;j<n;j++){

                userPass.add(in.next());

            }
            in.nextLine();
            String targetPasswords = in.nextLine();

            System.out.println(getSolution(userPass,targetPasswords));

        }

    }

    private static boolean getSolutionInner(List<String> userPass,final String targetPasswords,Deque<String> myStack,Set<String> visited) {

        boolean result = false;
        for(String x : userPass){
            if(visited.contains(x+"--"+targetPasswords)){
                continue;
            }

            if(targetPasswords.startsWith(x)){
                if(targetPasswords.length()>x.length()){

                    result = getSolutionInner(userPass,targetPasswords.substring(x.length()),myStack,visited);
                    if(result){
                        myStack.push(x);
                        break;
                    }else{
                        visited.add(x+"--"+targetPasswords);
                    }
                }else if(targetPasswords.length()==x.length()){
                    myStack.push(x);
                    result = true;
                    break;
                }
            }



        }
        return result;

    }


    public static String getSolution(List<String> userPass,final String targetPasswords) {


       Set<String> mySet = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        boolean aux = getSolutionInner(userPass,targetPasswords, stack,mySet);

        StringBuilder result = new StringBuilder();
        if(aux){
            stack.forEach(x-> result.append(x+" "));
            result.delete(result.length()-1,result.length());
        }else{
            result.append("WRONG PASSWORD");
        }

        return result.toString();

    }
}
