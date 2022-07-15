// https://leetcode.com/problems/max-area-of-island/submissions/
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][] {
                { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } })); // 6
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col]) {
                    ans = Math.max(ans, dfs(grid, visited, row, col));
                }
            }
        }
        return ans;
    }

    public static int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c] == true) {
            return 0;
        }
        visited[r][c] = true;
        return 1 + dfs(grid, visited, r + 1, c) + dfs(grid, visited, r, c + 1) + dfs(grid, visited, r, c - 1)
                + dfs(grid, visited, r - 1, c);

    }
}
