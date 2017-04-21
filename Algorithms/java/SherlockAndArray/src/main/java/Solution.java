import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int expectedElements = in.nextInt();
            int[] elements = new int[expectedElements];
            for(int j=0;j<expectedElements;j++){
                elements[j]=in.nextInt();
            }
            if(getSolution(elements)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean getSolution(int[] elements){
        long left = 0;
        long right = 0;
        for(int i=1;i<elements.length;i++){
            right += elements[i];
        }
        for(int candidate = 0;candidate<elements.length-1;candidate++){
            left+=elements[candidate];
            right-=elements[candidate+1];
            if(left==right){
                break;
            }
            //System.out.println(String.format("%d <- %d -> %d",left,candidate,right));
        }

        return left==right;
    }
}