import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        subsetSum(new int[] { 2, 3, 4, 5, 12, 34 }, 9);
    }

    public static void subsetSum(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        // making the first col true
        Arrays.stream(dp).forEach(ar -> ar[0] = true);
        // display(dp);

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                // there can be two cases:
                // I: we don't take the current element --> then we need to check if dp[row - 1][col] is true
                // II: we take the current element --> then X=(current target - current element)
                // should exist in the previous row
                if (dp[row - 1][col] || (col - arr[row - 1] >= 0 && dp[row - 1][col - arr[row - 1]])) {
                    dp[row][col] = true;
                }
            }
        }

        // display(dp);
        System.out.println(dp[arr.length][target]);
    }

    public static void display(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
