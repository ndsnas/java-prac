
// https://leetcode.com/problems/number-of-matching-subsequences/
// https://www.youtube.com/watch?v=9zzDQJLcY9Y&ab_channel=TimothyHChang
import java.util.*;

public class NumMatchingSubseq {
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
        System.out
                .println(numMatchingSubseq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(c, l);
            }
        }
        for (String w : words) {
            int prev = -1;
            boolean found = true;
            for (char c : w.toCharArray()) {
                if (!map.containsKey(c)) {
                    found = false;
                    break;
                }
                int temp = bs(map.get(c), prev);
                if (temp == map.get(c).size()) {
                    found = false;
                    break;
                } else {
                    prev = map.get(c).get(temp);
                }
            }
            if (found) {
                ans++;
            }
        }

        return ans;

    }

    public static int bs(List<Integer> list, int i) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (i < list.get(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
