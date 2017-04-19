/**
 * TrekAndSwim Created by dortega on 19/04/2017.
 */
public class Solution {

    //http://www.madaritech.com/trek-and-swim-best-performance-solution/
    //http://codilitysolutions.blogspot.com.es/
    public static void main(String[] args) {
        // TODO code application logic here
        Solution tr = new Solution();
        int A[];
        int result = 0;




        //////////Test the the results
        A = new int[]{1, 1, 0, 1, 0, 0, 1, 1, 0, 0};
        result = tr.solution(A);
        System.out.println("===========");
        System.out.println("The Result is    " + result);
        System.out.println("****************************************");

    }

    public int solution(int[] A) {


        int firstzero = -1;
        int lastone = -1;
        int seaDaysCount = 0;
        int seaEndIndex = 0;
        int seaArraySize;

        int mountainStartIndex = 0;

        /////get the first zero and last one
        for (int i = 0; i < A.length; i++) {
            if (firstzero == -1 && A[i] == 0) {
                firstzero = i;
            }
            if (A[i] == 1) {
                lastone = i;
            }
        }
        // return 0 if  no days for swim or no days for hike or no no hike day after a swim day
        if (firstzero == -1 || lastone == -1 || firstzero >= lastone) {
            return 0;
        }

        //get the longest sea trip that ends with ZERO
        int totalNumOfZeros = 0;
        for (int i = firstzero; i <= lastone; i++) {

            if (i == firstzero) {
                seaEndIndex = i;
            }
            if (A[i] == 0) {
                totalNumOfZeros++;
            }

            if (A[i] == 0&&seaTripNotFail(i - firstzero + 1, totalNumOfZeros)) {
                seaDaysCount = totalNumOfZeros;
                seaEndIndex = i;
            }

        }

        /// get the sea trip size
        seaArraySize = seaEndIndex - firstzero + 1;

        if (mountainStartIndex - seaEndIndex > 1) {
            return 0;
        }
        int startItrator = lastone;
        int tempones = 0;
        int tempZeros = 0;
        int tempEffectiveZeros = 0;
        int extraDays = 0;
        //check the possiblity of expanding the second part to the right by either adding more hike days from the first part or if the second part already adds elgiable to add more sea days from its right
        while (startItrator > firstzero) {
            if (extraDays + lastone >= A.length-1) {
                break;
            }
            if (startItrator > seaEndIndex) {
                if (A[startItrator] == 1) {
                    tempones++;
                    int newExtraDays = getExtraDays(tempones, tempZeros);
                    if (newExtraDays > extraDays) {
                        extraDays = newExtraDays;
                    }
                } else if (A[startItrator] == 0) {
                    tempZeros++;
                }
            } else {
                if (A[startItrator] == 1) {
                    tempones++;
                    int newExtraDays = getExtraDays(tempones, tempZeros);
                    if (newExtraDays > extraDays) {
                        int newArraySize = startItrator - firstzero + 1;
                        if (seaTripNotFail(newArraySize, seaDaysCount - tempEffectiveZeros)) {
                            extraDays = newExtraDays;
                            seaArraySize=newArraySize;
                            seaEndIndex=startItrator-1;
                            seaDaysCount=seaDaysCount - tempEffectiveZeros;
                            tempEffectiveZeros=0;
                        }
                    }
                } else if (A[startItrator] == 0) {
                    tempZeros++;
                    tempEffectiveZeros++;
                }
            }
            startItrator--;

        }
//      check if the first part elgiable to expand left or no
        int expantionValue = arrayExpandLeft(firstzero, seaDaysCount, seaArraySize, A);
        firstzero -= expantionValue;
        seaArraySize += expantionValue;

        int mountainTripDuration=lastone-seaEndIndex+extraDays;
        return seaArraySize+mountainTripDuration;

    }
    /// methods to get number of zeros that we can add to the seond part withought making it fail ( the number of ones should be greater than the number of zeros)
    int getExtraDays(int numOfOnes, int numOfZeros) {

        return numOfOnes - numOfZeros - 1;
    }


    // method to expand the first part of the trip  to the left side
    int arrayExpandLeft(int firstzero, int seaDaysCount, int seaArraySize, int[] A) {
        int expantionValue = 0;
        while (seaTripHasExtraSwimDays(seaArraySize, seaDaysCount) && firstzero > 0) {
            if (firstzero == 0) {
                break;
            }

            firstzero--;
            seaArraySize++;
            expantionValue++;

        }
        return expantionValue;
    }
    // cheack if the seatrip is ok with this size and this number of zeros
    boolean seaTripNotFail(int seaArraySize, int numOfZeros) {

        return numOfZeros - (seaArraySize - numOfZeros) >= 1;
    }
    // cheack if the seatrip is elgiable to add more ones
    boolean seaTripHasExtraSwimDays(int seaArraySize, int numOfZeros) {

        return numOfZeros - (seaArraySize - numOfZeros) > 1;
    }


}
