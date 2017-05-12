/**
 * CtciMakingAnagrams Created by dortega on 10/05/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        int result = 0;
        Map<Character,Integer> firstMap = new HashMap<>();
        Map<Character,Integer> secondMap = new HashMap<>();


        for(int i=0;i<first.length();i++){
            firstMap.put(first.charAt(i),firstMap.getOrDefault(first.charAt(i),0)+1);
        }
        for(int i=0;i<second.length();i++){
            char current = second.charAt(i);
            secondMap.put(current,secondMap.getOrDefault(current,0)+1);
            firstMap.computeIfPresent(current,(k,v)->v-1);


        }

        for(int i=0;i<first.length();i++){
            char current = first.charAt(i);
            secondMap.computeIfPresent(current,(k,v)->v-1);
        }


        for(Integer c : firstMap.values()){
            if(c>0){
                result+=c;
            }

        }
        for(Integer c : secondMap.values()){
            if(c>0){
                result+=c;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
