
// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
// https://www.youtube.com/watch?v=_SSGQTnmLu8&ab_channel=TimothyHChang
import java.util.*;

public class NumSubmatrixSumTarget {
    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } }, 3)); // 6
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        // calculate prefix sum of each row
        int ans = 0;
        for (int[] row : matrix) {
            for (int i = 1; i < row.length; i++) {
                row[i] += row[i - 1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {

                map.clear();
                map.put(0, 1);
                int cumSum = 0;
                for (int k = 0; k < matrix.length; k++) {
                    cumSum = cumSum + matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    ans = ans + map.getOrDefault(cumSum - target, 0);
                    map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
                }

            }
        }

        return ans;

    }
}
