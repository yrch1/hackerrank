/**
 * ReducedString Created by dortega on 17/05/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static String getSolution(String s){
        StringBuilder result = new StringBuilder();
        Vector<Character> myCollection = new Vector<>();
        for (int i = 0; i < s.length(); i++){

            myCollection.add(s.charAt(i));
        }
        int cursor=0;
        while(cursor<myCollection.size()-1){
            if(myCollection.elementAt(cursor)==myCollection.elementAt(cursor+1)){
                myCollection.removeElementAt(cursor);
                myCollection.removeElementAt(cursor);
                cursor = 0;
            }else{
                cursor++;
            }
        }

        for(Character item : myCollection){
            result.append(item);
        }
        if(result.length()==0){
            result.append("Empty String");
        }
        return result.toString();
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        String toProcess = in.next();

        String result = getSolution(toProcess);
        System.out.println(result);
        in.close();
    }
}