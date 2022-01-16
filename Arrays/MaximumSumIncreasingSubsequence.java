// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
// https://www.youtube.com/watch?v=5ToHur2XrA4&ab_channel=Pepcoding
import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        solution(new int[] {1, 101, 2, 3, 100, 4, 5});
    }
    
    public static void solution(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int overallMax = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            int maxSum = Integer.MIN_VALUE;

            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j]) {
                    maxSum = Math.max(dp[j] + arr[i], maxSum);
                }
            }
            overallMax = Math.max(overallMax, maxSum);
            dp[i] = maxSum;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(overallMax);
    }
}
