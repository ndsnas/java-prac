// https://leetcode.com/problems/interleaving-string/
// https://www.youtube.com/watch?v=79g3LJoQk_U&ab_channel=Pepcoding
// https://www.youtube.com/watch?v=ilibcYNpCE8&ab_channel=ProgrammingLivewithLarry

import java.util.*;

public class IsInterleave {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false

    }

    public static Boolean[][] dp;

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solution(s1, s2, s3, 0, 0);
    }

    public static boolean solution(String s1, String s2, String s3, int i, int j) {

        if (i + j == s3.length())
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            dp[i][j] = solution(s1, s2, s3, i + 1, j);
            if (dp[i][j])
                return true;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            dp[i][j] = solution(s1, s2, s3, i, j + 1);
            if (dp[i][j])
                return true;
        }
        dp[i][j] = false;
        return false;
    }
}
