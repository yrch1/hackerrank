import java.io.File;
import java.util.*;

/**
 * Created by yrch on 15/4/17.
 * https://www.hackerrank.com/challenges/icecream-parlor
 */
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

        int q = in.nextInt();
        for(int i=0;i<q;i++){
            int money = in.nextInt();
            int flavoursCount = in.nextInt();
            int[] flavours = new int[flavoursCount];
            for(int j=0;j<flavoursCount;j++){
                flavours[j]=in.nextInt();
            }

            System.out.println(getSolution(money,flavours));
        }

    }

    /**
     *
     * @param money
     * @param flavours
     * @return
     */
    public static String getSolution(int money, int[] flavours) {
        String result = "";

        Map<Integer,List<Integer>> myTree = new TreeMap<>();
        for(int i=0;i<flavours.length;i++){
            List<Integer> myPosition = myTree.get(flavours[i]);
            if(myPosition==null){
                myPosition = new ArrayList<>();
            }
            myPosition.add(i+1);
            myTree.put(flavours[i],myPosition);
        }

        int idA=1;
        int idB=1;
        int priceA = 0;
        int priceB = 0;
        Iterator<Integer> myPricesIterator = myTree.keySet().iterator();
        while(priceA+priceB<money && myPricesIterator.hasNext()){
            priceA = myPricesIterator.next();
            priceB = money-priceA;
            idA = myTree.get(priceA).get(0);
            if(money==2*priceA && myTree.get(priceA).size()>1){
                idB = myTree.get(priceA).get(1);
                break;
            }else if(myTree.containsKey(priceB)){
                idB = myTree.get(priceB).get(0);
                break;
            }
            priceA = 0;

        }

        if(idA>idB){
            idA = idA^idB;
            idB = idA^idB;
            idA = idA^idB;
        }

        result = String.format("%d %d",idA,idB);

        return result;
    }
}