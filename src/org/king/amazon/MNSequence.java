package org.king.amazon;

//@formatter:off
/**
 * Question 1:
 * 
 * Calculate the sum of N+NN+NNN+NNNN ... and there are total M N-sequence.
 * Input is :N[SPACE]M 
 * Both M, N are positive integer. please output the sum
 * Example1 Input: 1 2 then the sequence will be 1+11, Your output :12 
 * Example2 Input: 2 3 then the sequence will be 2+22+222,Your output :246
 * 
 * @author king
 *
 */
//@formatter:on
public class MNSequence {
    public static int calculate(int n, int m) {
        if (m < 0 || n < 0) {
            return -1;
        }

        int sum = 0;
        int fieldValue = 0;
        for (int i = 1; i <= m; i++) {
            fieldValue = fieldValue * 10 + n;
            sum += fieldValue;
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = 0;
        sum = calculate(1, 2);
        System.out.println(sum);

        sum = calculate(2, 3);
        System.out.println(sum);
    }
}
