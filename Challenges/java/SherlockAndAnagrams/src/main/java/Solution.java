import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static class Anagram{

        public Map<Character, Integer> numChars;
        private String aux;

        public Anagram(String str) {

            this.aux = str;
            numChars = new HashMap<>(Math.min(str.length(), 26));

            for (int i = 0; i < str.length(); ++i)
            {
                char charAt = str.charAt(i);

                if (!numChars.containsKey(charAt))
                {
                    numChars.put(charAt, 1);
                }
                else
                {
                    numChars.put(charAt, numChars.get(charAt) + 1);
                }
            }

        }

        @Override
        public boolean equals(Object obj) {

            Anagram other = (Anagram)obj;


            return other.numChars.equals(this.numChars);
        }

        @Override
        public int hashCode() {
            return numChars.hashCode();
        }

        @Override
        public String toString() {
            return aux;
        }
    }

    public static Map<Solution.Anagram,Integer> myCache = new HashMap<>();

    static int sherlockAndAnagrams(String s){
        // Complete this function
        myCache.clear();



        for(int i=1;i<s.length();i++){
            //Agrupando por tamaño i

            for(int j=0;j<=s.length()-i;j++){
                String aux = s.substring(j,j+i);
                Solution.Anagram myAnagram = new Solution.Anagram(aux);
                if(myCache.containsKey(myAnagram)){
                    int count = myCache.get(myAnagram)+1;
                    myCache.put(myAnagram,count);
                }else{
                    myCache.put(myAnagram,1);
                }
            }

        }

        int result = 0;
        for(Integer x : myCache.values()){
            if(x>1){
                int aux =binomial(x,2);
                result += aux;
            }

        }


        return result;
    }


    private static int binomial(int n, int k)
    {
        if (k>n-k)
            k=n-k;

        int b=1;
        for (int i=1, m=n; i<=k; i++, m--)
            b=b*m/i;
        return b;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
