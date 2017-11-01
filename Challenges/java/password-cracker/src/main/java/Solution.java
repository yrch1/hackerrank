import java.io.File;
import java.util.Scanner;

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

        int t = in.nextInt();

        for(int i=0;i<t;i++){

            int n = in.nextInt();
            String[] userPass = new String[n];

            for(int j=0;j<n;j++){

                userPass[j]=in.next();

            }

        }

    }
}
