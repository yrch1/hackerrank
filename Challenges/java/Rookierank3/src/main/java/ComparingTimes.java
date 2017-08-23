import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ComparingTimes {

    static SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
    static String timeCompare(String t1, String t2) throws Exception{
        // Complete this function
        String result="ERR";

        Date d1 =sdf.parse(t1);
        Date d2 = sdf.parse(t2);
        if(d1.compareTo(d2)<0){
            result = "First";
        }else{
            result = "Second";
        }


        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String t1 = in.next();
            String t2 = in.next();
            String result = timeCompare(t1, t2);
            System.out.println(result);
        }
    }
}
