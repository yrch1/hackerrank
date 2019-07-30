import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        String result = "NO";
        //System.out.println(String.format("La dimesion del array es %d", G.length));
        for(int i=0;i<G.length-P.length;i++){
            //System.out.println(G[i]);
            int j = 0;
            while(j<P.length && G[i+j].contains(P[j])){
                //System.out.println(String.format("Encontrado P[%d] = %s",j,P[j]));
                j++;
            }
            if(j==P.length){
                result = "YES";
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        try {
            if (args.length > 0) {
                scanner = new Scanner(new File(args[0]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = null;
        if(System.getenv("OUTPUT_PATH")!=null){
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        }else{
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }


        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}