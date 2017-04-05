import javafx.collections.transformation.SortedList;

import java.io.*;
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

        int len = in.nextInt();
        String s = in.next();

        int max = isValid(s)?s.length():0;
        String differntCharacters = differentCharacters(s);
        List<String> candidates = getAllSubSet(differntCharacters);

        System.out.println(candidates);


        for(String candidate : candidates){

            String currentReplaced = s;
            for(int i =0;i<candidate.length();i++){
                currentReplaced=currentReplaced.replaceAll(candidate.substring(i,i+1),"").trim();
            }

            if(isValid(currentReplaced)&& currentReplaced.length()>max){

                max = currentReplaced.length();
            }
        }
        System.out.println(max);
    }

    public static String differentCharacters(String s){
        String differntCharacters="";
        for(int i=0;i<s.length();i++){
            String current = s.substring(i,i+1);

            if(differntCharacters.indexOf(current)==-1){
                differntCharacters += current;
            }

        }
        return differntCharacters;
    }

    public static boolean isValid(String s){
        boolean result = true;
        String visited="";
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                result = false;
                break;
            }
            if(visited.indexOf(s.substring(i,i+1))==-1){
                visited+=s.substring(i,i+1);
            }
        }
        if(result){
            if(visited.length()>2){
                result = false;
            }
        }
        return result;
    }


    private static List<String> getAllSubSet(String differntCharacters) {
        List<String> list = new ArrayList<>();
        StringBuilder myBuilder = new StringBuilder();
        for(int desiredSize=0; desiredSize<2; ++desiredSize){
            getSubsetBySize(differntCharacters, myBuilder, list, desiredSize);
        }
        return list;
    }

    private static void getSubsetBySize(String original, StringBuilder current, List<String> myList, int desiredSize){

        current.append(original.charAt(desiredSize));
        myList.add(current.toString());
        for(int i=desiredSize+1; i<original.length(); ++i){
            getSubsetBySize(original, current, myList, i);
        }
        current.deleteCharAt(current.toString().length()-1);
        return;
    }
}