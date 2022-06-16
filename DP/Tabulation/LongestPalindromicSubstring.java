// https://leetcode.com/problems/longest-palindromic-substring/
// https://www.youtube.com/watch?v=WpYHNHofwjc&ab_channel=Pepcoding
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abccbc"));
    }

    public static String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        String ans = "";
        for(int gap=0; gap<dp.length; gap++){
            
            for(int row=0, col=gap; col<dp.length; row++, col++){
                
                if(gap==0){
                    dp[row][col]=true;
                }
                
                else if(gap==1){
                    dp[row][col] = s.charAt(row)==s.charAt(col);
                }
                
                else{
                    dp[row][col] = s.charAt(row)==s.charAt(col) && dp[row+1][col-1];
                }
                
                if(dp[row][col]){
                    // no need to check max of ans and new ans as we are moving in the loop the size of answer will always be increasing
                    ans=s.substring(row,col+1);
                }
            }
            
        }
        
        return ans;
    }
}