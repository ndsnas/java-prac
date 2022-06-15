// https://leetcode.com/problems/longest-string-chain/
import java.util.*;
public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
    }

    public static Map<String, Integer> map;
    public static int[] dp;
    public static int longestStrChain(String[] words) {
        if(words.length==1){
            return 1;
        }
        map = new HashMap<>();
        dp = new int[words.length];
        dp[0]=1;
        
        int ans = 0;
        //sort words according to length
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        
        //create reverse map :: word -> index
        for(int i=0; i<words.length; i++){
            map.put(words[i], i);
        }
        
        for(int j=1; j<words.length; j++){
            String curr = words[j];
            // longest chain till current word
            int score = getScore(curr);
            dp[j]=score;
            ans=Math.max(dp[j], ans);
        }
        
        return ans;
    }
    
    public static int getScore(String curr){
        int score = 0;
        for(int i=0; i<curr.length(); i++){
            // remove one character at a time from the current word and check if it present in the map and get the index from map and then check its score in the dp[]
            // get the max score by remove one charater at a time
            String newString = curr.substring(0,i) + curr.substring(i+1);
            if(map.containsKey(newString)){
                int newStringScore = dp[map.get(newString)];
                score=Math.max(score, newStringScore); 
            }
        }
        
        return score+1;
    }
}
