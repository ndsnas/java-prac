// https://leetcode.com/problems/paint-house-iii/
// https://www.youtube.com/watch?v=2J4tkJ7v3r4&ab_channel=ProgrammingLivewithLarry
public class PaintHouseThree {
    public static void main(String[] args) {
        System.out.println(minCost(new int[] { 0, 0, 0, 0, 0 },
                new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } }, 5, 2, 3)); // 9
        System.out.println(minCost(new int[] { 0, 2, 1, 2, 0 },
                new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } }, 5, 2, 3)); // 11
    }

    public static Boolean[][][] has_cache;
    public static int[][][] cache;

    public static int minCost(int[] houses, int[][] cost, int H, int C, int T) {
        has_cache = new Boolean[H + 1][C + 1][T + 1];
        cache = new int[H + 1][C + 1][T + 1];
        int ans = solution(houses, cost, H, C, T, 0, 0, 0);
        if (ans >= 9999999)
            return -1;
        else
            return ans;
    }

    public static int solution(int[] houses, int[][] cost, int H, int C, int T, int index, int last_color,
            int neighborhoods) {
        if (index == H) {
            if (neighborhoods == T) {
                return 0;
            }
            return 9999999;
        }

        if (neighborhoods > T)
            return 9999999;

        if (has_cache[index][last_color][neighborhoods] != null && has_cache[index][last_color][neighborhoods]) {
            return cache[index][last_color][neighborhoods];
        }
        // not already painted
        if (houses[index] == 0) {
            int ans = 9999999;
            // trying all colors
            for (int color = 1; color <= C; color++) {
                if (color == last_color) {

                    ans = Math.min(ans, solution(houses, cost, H, C, T, index + 1, last_color, neighborhoods)
                            + cost[index][color - 1]);
                } else {

                    ans = Math.min(ans, solution(houses, cost, H, C, T, index + 1, color, neighborhoods + 1)
                            + cost[index][color - 1]);

                }

            }
            has_cache[index][last_color][neighborhoods] = true;
            cache[index][last_color][neighborhoods] = ans;
            return ans;
        }

        // already painted
        else {
            int ans = 0;
            if (houses[index] == last_color) {
                ans = solution(houses, cost, H, C, T, index + 1, last_color, neighborhoods);
            } else {
                ans = solution(houses, cost, H, C, T, index + 1, houses[index], neighborhoods + 1);
            }
            has_cache[index][last_color][neighborhoods] = true;
            cache[index][last_color][neighborhoods] = ans;
            return ans;
        }
    }
}
