import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yrch on 23/8/17.
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class Solution {

    public static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }



    public static int getLargestIndex(final String inputString){
        int result = inputString.length()-1;;
        if(result>1){
            int i =result;
            while (i>0 && inputString.charAt(i-1)>= inputString.charAt(i)){
                i--;
            }
            result=i-1;
        }


        return  result;

    }

    public static int getRightMostSuccessor(String inputString, char d) {
        int j = inputString.length() - 1;
        while (j>0 && inputString.charAt(j) <= d)
            j--;

        return j;

    }

    public static String reverseString(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    public static String replaceCharAt(final String inputString, int pos, char replacement){
        StringBuilder result = new StringBuilder(inputString);
        result.setCharAt(pos, replacement);
        return result.toString();
    }

    public static String getSolution(final String inputString){
        String solution = "no answer";
        int largestIndex = getLargestIndex(inputString);
        if(largestIndex>=0){

            int rightMostSuccessor= getRightMostSuccessor(inputString,inputString.charAt(largestIndex));

            //swap
            char temp = inputString.charAt(largestIndex);
            String aux = Solution.replaceCharAt(inputString,largestIndex,inputString.charAt(rightMostSuccessor));
            aux = Solution.replaceCharAt(aux,rightMostSuccessor,temp);
            solution = aux.substring(0,largestIndex+1);

            solution+= Solution.reverseString(aux.substring(largestIndex+1));

        }



        return solution.equals(inputString)?"no answer":solution;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader s=new FastReader();

        int n = s.nextInt();
        for(int i=0;i<n;i++){
            System.out.println(Solution.getSolution(s.next()));
        }
    }



}
