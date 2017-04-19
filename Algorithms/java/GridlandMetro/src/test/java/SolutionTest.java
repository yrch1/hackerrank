import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * GridlandMetro Created by dortega on 19/04/2017.
 */
public class SolutionTest {
    @Test
    public void getSolution() throws Exception {


        boolean[][] trackMap = new boolean[4][4];
        trackMap[1][1]=true;
        trackMap[1][2]=true;

        trackMap[2][0]=true;
        trackMap[2][1]=true;
        trackMap[2][2]=true;
        trackMap[2][3]=true;


        trackMap[3][3]=true;

        Assert.assertEquals(9,Solution.getSolution(4,4,trackMap));
    }

    @Test
    public void getSolution2() throws Exception {


        boolean[][] trackMap = new boolean[4][3];
        trackMap[1][1]=true;
        Assert.assertEquals(11,Solution.getSolution(4,3,trackMap));
    }

    @Test
    public void getSolution4() throws Exception {

        String original = "00-44  48 5555 8361";
        String s = getString(original);
        Assert.assertEquals("004-448-555-583-61",s);

        Assert.assertEquals("022-198-53-24",getString("0 - 22 1985--324"));
        Assert.assertEquals("555-372-654",getString("555-   --372-    654"));
        Assert.assertEquals("555",getString("5-55   "));
        Assert.assertEquals("55-53",getString("5-553   "));
        Assert.assertEquals("555-32",getString("5  ----5---5-32"));
        System.out.println(s);
    }

    private String getString(String original) {
        String s = original.replaceAll("\\s|-","");
        if(s.length()%3==1){
            s = s.substring(0,s.length()-4).replaceAll("(\\d{3})","$1-")+s.substring(s.length()-4).replaceAll("(\\d{2})(\\d{2})","$1-$2");
        }else{
            s = s.substring(0,s.length()-s.length()%3).replaceAll("(\\d{3})","$1-")+s.substring(s.length()-s.length()%3);
        }
        if(s.endsWith("-")){
            s = s.substring(0,s.length()-1);
        }
        return s;
    }



    @Test
    public void getSolution5() throws Exception {

        int A[] = new int[8];

        A[0] = 7;
        A[1] = 3;
        A[2] = 7;
        A[3] = 3;
        A[4] = 1;
        A[5] = 3;
        A[6] = 4;
        A[7] = 1;

        Assert.assertEquals(5,solution(A));

        int b[] = new int[8];

        b[0] = 1;
        b[1] = 1;
        b[2] = 1;
        b[3] = 1;
        b[4] = 1;
        b[5] = 1;
        b[6] = 2;
        b[7] = 3;

        Assert.assertEquals(3,solution(b));


        int c[] = new int[2];

        c[0] = 1;
        c[1] = 1;

        Assert.assertEquals(1,solution(c));


        Assert.assertEquals(4,solution(new int[]{2,3,4,4,2,3,5}));

    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> places = new HashSet<>();
        for(int i=0;i<A.length;i++){
            places.add(A[i]);
        }
        int max = A.length;
        for(int i=0;i<A.length-1;i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(A[i]);
            if(visited.size()!=places.size()){
                for(int j=i+1;j<A.length;j++){
                    visited.add(A[j]);
                    if(visited.size()==places.size()){
                        if(j-i<max){
                            max = j-i;
                            break;
                        }
                    }
                }
            }else{
                max =0;
            }
        }
        return max+1;
    }





}