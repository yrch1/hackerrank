import java.util.Scanner;

public class Solution {

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static boolean getSolution(final String toTest){
        boolean result = true;
        String workingCopy = toTest.toLowerCase();
        for(int i=0;i<alphabet.length;i++){
            if(workingCopy.indexOf(alphabet[i])==-1){
                result = false;

                break;
            }
        }
        return result;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in  = new Scanner(System.in);

        System.out.print(getSolution(in.nextLine()) ? "pangram ":"not pangram");

        in.close();
    }


}
