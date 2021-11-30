
// https://www.geeksforgeeks.org/sudoku-backtracking-7/
// https://www.youtube.com/watch?v=uyetDh-DyDg&ab_channel=Pepcoding
import java.util.*;

public class Sudoku {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        solveSudoku(arr, 0, 0);
    }

    public static void solveSudoku(int[][] board, int row, int col) {

        if (row > 8) {
            display(board);
            return;
        }

        int nextRow, nextCol;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (board[row][col] == 0) {

            for (int i = 1; i <= 9; i++) {
                if (isValid(i, board, row, col)) {
                    board[row][col] = i;
                    solveSudoku(board, nextRow, nextCol);
                    // setting zero here because when we backtrack two steps then when we will be
                    // back to this element then it should be zero so that a new valid number can be
                    // filled here
                    board[row][col] = 0;
                }
            }
        }

        else {
            solveSudoku(board, nextRow, nextCol);
        }

    }

    public static boolean isValid(int val, int[][] board, int row, int col) {

        // check in row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // check in col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        // check in 3X3

        int cornerRow = (row / 3) * 3;
        int cornerCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[cornerRow + i][cornerCol + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void display(int[][] board) {
        System.out.println("***********************");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

/*
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 */