import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        System.out.println(stepsToWin(c,0));
    }

    public static int stepsToWin(int[] clouds,int currentOne){
        int result;
        if(currentOne ==clouds.length-1){
            result = 0;
        }else{
            int aux1 = Integer.MAX_VALUE;
            int aux2 = Integer.MAX_VALUE;
            if(currentOne+1<clouds.length && clouds[currentOne+1]==0){
                aux1 = 1+stepsToWin(clouds,currentOne+1);
            }
            if(currentOne+2<clouds.length && clouds[currentOne+2]==0){
                aux2 = 1+stepsToWin(clouds,currentOne+2);
            }
            if(aux1<aux2){
                result = aux1;
            }else{
                result = aux2;
            }
        }
        return result;

    }
}
