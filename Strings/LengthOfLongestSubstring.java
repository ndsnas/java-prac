// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://www.youtube.com/watch?v=9Kc0eZBGL1U&ab_channel=Pepcoding
import java.util.*;
public class LengthOfLongestSubstring{
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int lPointer=-1;
        int rPointer=-1;
        int seqLen=0;
        int currSeqLen=0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(true){
            boolean flag1=false;
            boolean flag2=false;
            currSeqLen=0;
            while(rPointer < s.length()-1){
                flag1=true;
                rPointer++;
                Character ch = s.charAt(rPointer);
                if(map.containsKey(ch) && map.get(ch) > 0){
                    map.put(ch, map.get(ch)+1);
                    break;
                }
                else{
                    map.put(ch, 1);
                    if((rPointer-lPointer) > seqLen){
                        seqLen=rPointer-lPointer;
                    }
                    
                }
                
            }
            while(lPointer < rPointer){
                flag2=true;
                lPointer++;
                Character ch = s.charAt(lPointer);
                map.put(ch, map.get(ch)-1);
                if(map.get(s.charAt(rPointer)) < 2){
                    break;
                }
                
            }
            if(!flag1 && !flag2) break;
            
        }
        
        return seqLen;
    }
}