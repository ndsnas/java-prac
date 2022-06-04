
// https://leetcode.com/problems/n-queens/
// https://www.youtube.com/watch?v=yvt0emtFiIE&ab_channel=Pepcoding
import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(4);

        for (List<String> solution : solutions) {
            System.out.println(Arrays.toString(solution.toArray()));
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> asf = new ArrayList<>();
        boolean[] blockedCol = new boolean[n];
        boolean[] blockedDiag = new boolean[2 * n - 1];
        boolean[] blockedRevDiag = new boolean[2 * n - 1];
        solve(n, blockedCol, blockedDiag, blockedRevDiag, ans, asf, 0);
        return ans;
    }

    public static void solve(int n, boolean[] blockedCol, boolean[] blockedDiag, boolean[] blockedRevDiag,
            List<List<String>> ans, List<String> asf, int row) {

        if (row == n) {
            ans.add(new ArrayList(asf));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (blockedCol[col] == false && blockedDiag[row + col] == false
                    && blockedRevDiag[row - col + n - 1] == false) {
                String asfString = createAsfString(n, col);
                asf.add(asfString);
                blockedCol[col] = true;
                blockedDiag[row + col] = true;
                blockedRevDiag[row - col + n - 1] = true;
                solve(n, blockedCol, blockedDiag, blockedRevDiag, ans, asf, row + 1);
                asf.remove(asf.size() - 1);
                blockedCol[col] = false;
                blockedDiag[row + col] = false;
                blockedRevDiag[row - col + n - 1] = false;
            }
        }
    }

    public static String createAsfString(int n, int col) {
        char[] asf = new char[n];
        for (int i = 0; i < n; i++) {
            if (i == col) {
                asf[i] = 'Q';
            } else {
                asf[i] = '.';
            }
        }
        return String.valueOf(asf);
    }
}
