//https://www.youtube.com/watch?v=UvksR0hR9nA&t=2434s&ab_channel=Pepcoding
public class EggDroppingProblem {
    public static void main(String[] args) {
        solution(3, 7);
    }

    public static void solution(int e, int f) {
        int dp[][] = new int[e + 1][f + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = i;
        }
        display(dp);
        for (int row = 2; row < dp.length; row++) {
            for (int col = 2; col < dp[0].length; col++) {
                int temp1 = Integer.MAX_VALUE;
                for (int i = 0; i < col; i++) {
                    int temp2 = Math.max(dp[row - 1][i], dp[row][col - 1 - i]);
                    temp1 = Math.min(temp1, temp2);
                }
                dp[row][col] = temp1 + 1;
            }
        }
        display(dp);
        System.out.println(dp[e][f]);
    }

    public static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
