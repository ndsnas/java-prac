//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
//https://www.youtube.com/watch?v=SoxrXQbhCPI&ab_channel=Pepcoding

//anti-clockwise
public class RotateMatrix {

    public static void main(String[] args) {
        int matrix1[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int matrix[][] = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 9, 10, 11 }
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        // taking transpose of the matrix
        for (int row = 0; row < matrix.length; row++) {
            // take only the upper right triangular matrix
            // otherwise it won't transpose if all the elements are taken
            for (int col = row; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // reverse the matrix -- swap the rows
        // swap 1st and nth row, 2nd and n-2 row and so on
        for (int row = 0; row < (matrix.length / 2); row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
        }
        display(matrix);
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
