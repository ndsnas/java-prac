
//https://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
import java.util.*;

public class AlternateOXRectangleMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.close();
        char[][] matrix = new char[rows][cols];
        createMatrix(matrix);
        for (char[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // used spiral traversal technique to insert element in the matrix
    // Ref: https://www.youtube.com/watch?v=SVFXEqn3Ceo&ab_channel=Pepcoding
    public static void createMatrix(char[][] matrix) {
        int min_row = 0;
        int min_col = 0;
        int max_row = matrix.length - 1;
        int max_col = matrix[0].length - 1;
        int matrixSize = matrix.length * matrix[0].length;
        int count = 0;
        char symbol = 'X';
        while (count < matrixSize) {
            // left wall
            for (int row = min_row, col = min_col; row <= max_row && count < matrixSize; row++) {
                matrix[row][col] = symbol;
                count++;
            }
            min_col++;

            // bottom wall
            for (int row = max_row, col = min_col; col <= max_col && count < matrixSize; col++) {
                matrix[row][col] = symbol;
                count++;
            }
            max_row--;

            // right wall
            for (int row = max_row, col = max_col; row >= min_row && count < matrixSize; row--) {
                matrix[row][col] = symbol;
                count++;
            }
            max_col--;

            // top wall
            for (int row = min_row, col = max_col; col >= min_col && count < matrixSize; col--) {
                matrix[row][col] = symbol;
                count++;
            }
            min_row++;

            symbol = symbol == 'X' ? 'O' : 'X';
        }
    }

}
