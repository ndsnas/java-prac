// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
// https://www.youtube.com/watch?v=gBlKWymU1bw&ab_channel=ProgrammingLivewithLarry

import java.util.*;
public class MinDeletions {
    public static void main(String[] args) {
        System.out.println(minDeletions("aab")); //0
        System.out.println(minDeletions("aaabbbcc")); //2
        System.out.println(minDeletions("ceabaacb")); //2
    }

    public static int minDeletions(String s) {
        Map <Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        int deletion = 0;
        for(Integer x : map.values()){
            while(set.contains(x) && x>0){
                x--;
                deletion++;
            }
            set.add(x);
        }
        return deletion;
    }
}
