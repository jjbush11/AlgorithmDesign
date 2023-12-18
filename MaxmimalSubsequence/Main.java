// Worked on with Anthony Mazzola
public class Main {
    public static void main(String argv[]) {
        testOne();
        testTwo();
    }

    //------------------------------------------------------------

    public static void testOne() {
        Integer S[] = {19, 5, -3, 10, -20, -1, -25, -4, 10, 10, -16, 19, -21, 21, 22, -18};
        Integer rtnval[] = maxsub(S);
        System.out.println("from D&T: sum = " + rtnval[0] + "; start = " + rtnval[1] + "; end = " + rtnval[2]);
        rtnval = bruteForce(S);
        System.out.println("from BF: sum = " + rtnval[0] + "; start = " + rtnval[1] + "; end = " + rtnval[2]);
    }

    //------------------------------------------------------------

    public static void testTwo() {
        Integer S[] = {-2, -5, 6, -4, -1};
        Integer rtnval[] = maxsub(S);
        System.out.println("from D&T: sum = " + rtnval[0] + "; start = " + rtnval[1] + "; end = " + rtnval[2]);
        rtnval = bruteForce(S);
        System.out.println("from BF: sum = " + rtnval[0] + "; start = " + rtnval[1] + "; end = " + rtnval[2]);
    }

    //------------------------------------------------------------

    public static Integer[] maxsubMid(Integer[] S, int start, int mid, int end) {
        int max_sum_left = S[mid];
        int start_index_left = mid;
        int sum = S[mid];
        int idx = mid - 1;
        Integer rtnVal[] = new Integer[3];

        while (idx >= start) {
            if (S[idx] + sum > max_sum_left) {
                max_sum_left = S[idx] + sum;
                start_index_left = idx;
            }
            sum = sum + S[idx];
            idx = idx - 1;
        }
        if (mid == end) {
            rtnVal[0] = max_sum_left;
            rtnVal[1] = start_index_left;
            rtnVal[2] = mid;
            return rtnVal;
        }
        int max_sum_right = S[mid+1];
        int end_index_right = mid+1;
        sum = S[mid+1];
        idx = mid+2;
        while (idx <= end) {
            if (S[idx] + sum > max_sum_right) {
                max_sum_right = S[idx] + sum;
                end_index_right = idx;
            }
            sum = sum + S[idx];
            idx = idx + 1;
        }

        rtnVal[0] = max_sum_left + max_sum_right;
        rtnVal[1] = start_index_left;
        rtnVal[2] = end_index_right;
        return rtnVal;
    }

    //------------------------------------------------------------

    public static Integer[] maxsubRec(Integer[] S, int start, int end) {
        Integer rtnVal[] = new Integer[3];
        int mid;
        Integer left_result[] = new Integer[3];
        Integer right_result[] = new Integer[3];
        Integer middle_result[] = new Integer[3];

        if (start == end) {
            rtnVal[0] = S[start];
            rtnVal[1] = start;
            rtnVal[2] = end;
            return rtnVal;
        } else {
            mid = (start + end) / 2;
            left_result = maxsubRec(S, start, mid);
            right_result = maxsubRec(S, mid+1, end);
            middle_result = maxsubMid(S, start, mid, end);

            // return whichever one of these three has the largest sum value
            Integer[][] findMax = new Integer[3][3];
            findMax[0] = left_result;
            findMax[1] = right_result;
            findMax[2] = middle_result;
            int maxSum =0;
            for (Integer[] sumArr : findMax) {
                if (sumArr[0] == null)
                    continue;
                else if (sumArr[0] > maxSum) {
                    maxSum = sumArr[0];
                    rtnVal = sumArr;
                }
            }
            return rtnVal;
        }
    }

    //------------------------------------------------------------

    public static Integer[] maxsub(Integer[] S) {
        return maxsubRec(S, 0, S.length-1);
    }

    //------------------------------------------------------------

    public static Integer[] bruteForce(Integer[] S) {
        // Declare all vars
        int i, j;
        int maxSequence = 0, finalMax = 0;
        int startIndex = 0, endIndex = 0;
        Integer rtnVal[] = new Integer[3];

        // Nested for loop
        for (i=0; i<S.length; ++i){
            maxSequence = 0;
            for (j=i; j<S.length; ++j){

                maxSequence += S[j];

                // Save indexes if maxSeq is greater than previous max
                if (maxSequence > finalMax){
                    endIndex = j;
                    finalMax = maxSequence;
                    startIndex = i;
                }
            }
        }

        rtnVal[0] = finalMax;
        rtnVal[1] = startIndex;
        rtnVal[2] = endIndex;

        return rtnVal;
    }
}
