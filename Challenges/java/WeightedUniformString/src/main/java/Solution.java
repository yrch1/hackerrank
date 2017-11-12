import java.util.*;

public class Solution {

    public static int getValue(char c){
        return ((int)c)-96;
    }

    public static Set<Integer> prepareMyHash(final String str){

        Set<Integer> result = new HashSet<>();
        int contigentString = 1;
        int count = 0;
        for(int i=0 ;i< str.length(); i ++){
            int currentValue = getValue(str.charAt(i));
            if(currentValue == count){
                contigentString++;
            }
            else{
                contigentString = 1;
                count = currentValue;
            }
            int num = (currentValue) * contigentString;
            result.add(num);
        }
        return result;
    }


    public static boolean getSolution(final Set<Integer> myHash, int target){
        return myHash.contains(target);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        Set<Integer> myHash = prepareMyHash(s);

        //System.out.println(Arrays.toString(myHash.toArray()));


        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here

            System.out.println(getSolution(myHash,x)?"Yes":"No");
        }
    }
}
