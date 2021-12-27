
// https://www.geeksforgeeks.org/remove-invalid-parentheses/
// https://www.youtube.com/watch?v=Cbbf5qe5stw&ab_channel=Pepcoding
import java.util.*;

public class InvalidParenthesis {
    public static void main(String[] args) {
        String str1 = "()())()";
        String str2 = "(v)())()";
        String str = "()v)";
        printValid(str, getInvalidParenthesisToRemove(str), new HashSet<>());
    }

    // get min number of parenthesis need to be removed
    public static int getInvalidParenthesisToRemove(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else if ((c == ')' && stack.empty()) || (c == ')' && stack.peek() == ')')) {
                stack.push(')');
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            }
        }

        return stack.size();
    }

    // mtr == minimum needed to be removed
    public static void printValid(String str, int mtr, HashSet<String> setOfValid) {

        if (mtr == 0) {
            if (getInvalidParenthesisToRemove(str) == 0 && !setOfValid.contains(str)) {
                setOfValid.add(str);
                System.out.println(str);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // remove the ith parenthesis and create the string
            String prefix = str.substring(0, i);
            String suffix = str.substring(i + 1, str.length());
            // subtracting 1 from mtr whenever we remove a parenthesis
            // during 2nd recursion call 2 would be subtracted from mtr and so on
            // base condition is on to check when mtr becomes 0
            printValid(prefix + suffix, mtr - 1, setOfValid);
        }
    }
}
