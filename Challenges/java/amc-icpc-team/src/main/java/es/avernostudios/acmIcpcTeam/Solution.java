package es.avernostudios.acmIcpcTeam;

import java.io.*;
import java.util.*;

public class Solution {

    public static Map<Integer,Integer> cache = new HashMap<>();

    private static BitSet fromString(String binary) {
        BitSet bitset = new BitSet(binary.length());
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }


    public static int maxNumberOfTopics(String[] topic){
        int result = 0;
        for(int i=0;i<topic.length;i++){
            BitSet a = fromString(topic[i]);
            for(int j=i+1;j<topic.length;j++){
                BitSet b = fromString(topic[j]);
                b.or(a);
                //System.out.println(String.format("[%d-%d] = %d or %d -> %d osea %s que tiene %d",i,j,a,b,a|b,aux,countOnes(aux)));
                int aux2 = b.cardinality();
                if(aux2>result){
                    result = aux2;
                }
                cache.put(aux2,cache.get(aux2)+1);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            if (args.length > 0) {
                in = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        initCache(m);
        for(int topic_i=0; topic_i < n; topic_i++){

            topic[topic_i] = in.next();
        }
        int aux = maxNumberOfTopics(topic);
        System.out.println(aux);
        System.out.println(cache.get(aux));

    }

    public static void initCache(int m) {
        for(int topic_i=0; topic_i <= m; topic_i++){
            cache.put(topic_i,0);
        }
    }
}