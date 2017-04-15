/**
 * Created by yrch on 13/4/17.
 */
import java.util.*;

public class Solution {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextShort();
        int b = in.nextShort();
        int c = in.nextShort();
        int d = in.nextShort();


        long count = getQuadruples(a, b, c, d);
        System.out.println(count);

    }

    public static long getQuadruples(int v1, int v2, int v3, int v4){
        int[] total = new int[3010];

        int[][] cnt = new int[3010][4200];

        int[] arr = new int[4];
        arr[0]=v1;
        arr[1]=v2;
        arr[2]=v3;
        arr[3]=v4;

        Arrays.sort(arr);


        for(int i = 1;i<=arr[0];i++){
            for(int j=i;j<=arr[1];j++){
                total[j]++;
            }
        }

        for(int i=1;i<=3000;i++){
            total[i] += total[i-1];
        };
        for(int i = 1;i<=arr[0];i++){
            for(int j=i;j<=arr[1];j++){
                int x = i ^ j;
                cnt[j][x]++;
            }
        }

        for(int i=1;i<=3000;i++){
            for(int j=0;j<=4100;j++){
                cnt[i][j] += cnt[i-1][j];
            }
        }


        long res = 0;
        for(int i = 1;i<=arr[2];i++){
            for(int j=i;j<=arr[3];j++){
                int y = i ^ j;

                res += total[i] - cnt[i][y];
            }
        }


        return res;
    }
}