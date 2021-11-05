import java.util.*;

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(gridTraveler(0, 0));
        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(3, 3));
        System.out.println(gridTraveler(4, 3));
    }

    private static int gridTraveler(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        int[][] table = new int[m + 1][n + 1];
        Arrays.stream(table).forEach(arr -> Arrays.fill(arr, 0));
        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < n)
                    table[i][j + 1] += table[i][j];
                if (i < m)
                    table[i + 1][j] += table[i][j];
            }
        }

        System.out.println(Arrays.deepToString(table));
        return table[m][n];
    }
}
