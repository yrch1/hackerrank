/**
 * Created by dortega on 06/04/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        System.out.println(getPosition(a,v));
    }

    public static int getPosition(int[] a,int v){
        return getPositionInner(a,v,0,a.length-1);
    }

    public static int getPositionInner(int[] a,int v,int lo, int hi){
        int result = -1;
        if(lo<hi){
            int mid = lo + (hi - lo) / 2;
            if(a[mid]==v){
                result = mid;
            }else if(a[mid]<v){
                result = getPositionInner(a,v,mid+1,hi);
            }else{
                result = getPositionInner(a,v,lo,mid-1);
            }
        }else if(lo==hi){
            if(a[lo]==v){
                result = lo;
            }
        }
        return result;
    }
}