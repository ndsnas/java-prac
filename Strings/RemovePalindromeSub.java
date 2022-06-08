// https://leetcode.com/problems/remove-palindromic-subsequences/
public class RemovePalindromeSub {
    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub("abb"));
    }

    public static int removePalindromeSub(String s) {
        // if the string is palindromic then ans will be 1
        if (isPalindrome(s)) {
            return 1;
        }
        // string can be made palindromic by removing 1 char as it only contains 'a' or
        // 'b'
        return 2;

    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < Math.floor(length / 2); i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i))
                return false;
        }
        return true;
    }
}
