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

            /*userPass.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int x= o1.length();
                    int y = o2.length();
                    if(x>y){
                        return -1;
                    }else if(x==y){
                        return o1.compareTo(o2);
                    }else{
                        return 1;
                    }
                }
            });*/
            in.nextLine();
            String targetPasswords = in.nextLine();

            getSolution(userPass,targetPasswords);

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


    private static void getSolution(List<String> userPass,final String targetPasswords) {


       Set<String> mySet = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        boolean aux = getSolutionInner(userPass,targetPasswords, stack,mySet);
        if(aux){
            stack.forEach(x->{
                System.out.print(x+" ");
            });
            System.out.println("");
        }else{
            System.out.println("WRONG PASSWORD");
        }

    }
}
