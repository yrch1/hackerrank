package es.avernostudios.hackerrank.challenges.twoCharacters;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static List<String> combinationUtil(char arr[], char data[], int start,
                                        int end, int index, int r) {
        List<String> result = new ArrayList<>();
        // Current combination is ready to be printed, print it
        if (index == r) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < r; j++) {
                stringBuilder.append(data[j]);

            }
            result.add(stringBuilder.toString());
            return result;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            result.addAll(combinationUtil(arr, data, i + 1, end, index + 1, r));
        }
        return result;
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static List<String> getCombination(char arr[], int n) {
        // A temporary array to store all combination one by one
        char data[] = new char[arr.length];

        // Print all combination using temprary array 'data[]'
        return combinationUtil(arr, data, 0, arr.length - 1, 0, n);
    }


    static boolean isValid(final String s) {
        boolean result=false;

        if(s.length()>1) {
            result = true;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    result = false;
                    break;
                }
            }
        }else{
            result = true;
        }

        return result;
    }

    static int twoCharacters(String s) {
        int count = 0;

        // Complete this function
        Set<Character> characterSet = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            characterSet.add(s.charAt(i));
        }

        char[] aux = new char[characterSet.size()];
        int i = 0;
        for (Character x : characterSet) {
            aux[i++] = x;
        }

        List<String> actual = Solution.getCombination(aux, 2);


        for (String s1 : actual) {
            String regex = String.format("[^%c%c]", s1.charAt(0), s1.charAt(1));
            String candidate = s.replaceAll(regex, "");
            if (isValid(candidate)) {
                System.out.println(String.format("%s -> %d",candidate,candidate.length()));
                if (count < candidate.length()) {
                    count = candidate.length();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharacters(s);
        System.out.println(result);
        in.close();
    }
}