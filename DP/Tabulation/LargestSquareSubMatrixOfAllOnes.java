// https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
// https://www.youtube.com/watch?v=UagRoA3C5VQ&ab_channel=Pepcoding
public class LargestSquareSubMatrixOfAllOnes {

    public static void main(String[] args) {

        solution(new int[][] { { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 } });

    }

    public static void solution(int[][] matrix) {
        int table[][] = new int[matrix.length][matrix[0].length];
        int answer = 0;
        // seeding value
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                // setting the value in table as 0 wherever matrix is 0
                if (matrix[row][col] == 0) {
                    table[row][col] = 0;
                }
                // setting the value in table as 1 if there is value 1 in last row or last col
                // of matrix
                if ((row == matrix.length - 1 || col == matrix[0].length - 1) && matrix[row][col] == 1) {
                    table[row][col] = 1;
                }
            }
        }

        for (int row = table.length - 2; row >= 0; row--) {
            for (int col = table[0].length - 2; col >= 0; col--) {
                if (matrix[row][col] == 1) {
                    int minValueAround = Math.min(Math.min(table[row][col + 1], table[row + 1][col]),
                            table[row + 1][col + 1]);
                    table[row][col] = minValueAround + 1;
                    if (minValueAround + 1 > answer) {
                        answer = minValueAround + 1;
                    }
                }

            }
        }
        display(table);
        System.out.println(answer);
    }

    public static void display(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
