// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
// https://www.youtube.com/watch?v=zIyhKenHbvs&ab_channel=ProgrammingLivewithLarry
public class DeciBinary {
    public static void main(String[] args) {
        System.out.println(minPartitions("1345")); // 5
        System.out.println(minPartitions("27346209830709182346")); // 9
    }

    public static int minPartitions(String n) {
        int ans = 0;
        // Ans will always be the largest DIGIT in the given number.
        // Because we'd need atleast that many 1's to add up to that largest DIGIT.
        for (char c : n.toCharArray()) {
            ans = Math.max(ans, c-'0');
        }
        return ans;
    }
}
