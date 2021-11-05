import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 },
                { 17, 18, 19, 20 } };
        printFirstHalf(matrix);
        printSecondHalf(matrix);
    }

    private static void printFirstHalf(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int row = i;
            for (int j = 0; j <= i && j < matrix[0].length; j++) {
                int col = j;
                System.out.print(matrix[row][col] + " ");
                row--;
            }
            System.out.println();
        }
    }

    private static void printSecondHalf(int[][] matrix) {
        // sum of last index of matrix (last i + last j)
        int totalSum = matrix.length - 1 + matrix[0].length - 1;
        int row = matrix.length - 1;
        for (int i = 0; i < totalSum - row; i++) {
            int row2 = row;
            for (int j = i + 1; j < matrix[0].length; j++) {
                int col = j;
                System.out.print(matrix[row2][col] + " ");
                row2--;
            }
            System.out.println();
        }
    }
}