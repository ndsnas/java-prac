// https://leetcode.com/problems/delete-operation-for-two-strings/
// https://www.youtube.com/watch?v=P6mfDwGkKkc
import java.util.*;
public class DeleteOperationForTwoStrings {

    public static int[][] dp;
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        dp = new int[word1.length()+1][word2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(solve(word1, word2,0,0));
    }

    // Try with tabulation as well
    public static int solve(String w1, String w2, int i, int j){
        if(i==w1.length() && j==w2.length()) return 0;
        if(i==w1.length() || j==w2.length()) return Math.max(w1.length()-i, w2.length()-j);
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return solve(w1, w2, i+1, j+1);
        return dp[i][j] = 1+Math.min(solve(w1,w2,i+1,j), solve(w1,w2,i,j+1));
    }
    
}
