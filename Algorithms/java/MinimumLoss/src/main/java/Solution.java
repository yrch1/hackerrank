import java.util.*;

/**
 * MinimumLoss Created by dortega on 04/05/2017.
 */
public class Solution {

    public static class MyPair{
        int index;
        int price;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }


        public MyPair(int index, int price){
            this.index = index;
            this.price = price;
        }




    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]  arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.print(getSolution2(arr));
    }

    public static int getSolution2(int arr[]){
        int min = Integer.MAX_VALUE;
        List<MyPair> myList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            myList.add(new MyPair(i,arr[i]));
        }


        Collections.sort(myList,(o1, o2) -> {
            int result = 0;
            if(o1.price<o2.price){
                result = -1;
            }else if(o1.price>o2.price){
                result = 1;
            }
            return result;
        });

        return min;
    }

    public static int getSolution(int arr[]){
        int min = Integer.MAX_VALUE;
        List<Integer> visited = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(!visited.contains(arr[i])){
                visited.add(arr[i]);
                for(int j=i+1;j<arr.length;j++) {
                    int current = arr[i] - arr[j];
                    if (current > 0 && current < min) {
                        min = current;
                    }
                }
            }


        }
        return min;
    }
}
