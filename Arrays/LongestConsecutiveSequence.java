
// https://leetcode.com/problems/longest-consecutive-sequence/
// https://www.youtube.com/watch?v=CPzUOvBv3Vs
// https://www.youtube.com/watch?v=YWXbu5uyGXs&ab_channel=Pepcoding
import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }

    public static int longestConsecutive(int[] nums) {
        int best = 0;
        // storing in set for O(1) lookup operations
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i : nums) {
            // if i-1 is not in set then it means i can be a starting point for a sequence
            if (!set.contains(i - 1)) {
                best = Math.max(best, getCurrentStreak(i, set));
            }
        }

        return best;
    }

    // checking the length of sequence starting from startingPoint
    public static int getCurrentStreak(int startingPoint, Set<Integer> set) {
        int current = startingPoint + 1;
        int streak = 1;
        while (set.contains(current)) {
            current++;
            streak++;
        }

        return streak;
    }
}
