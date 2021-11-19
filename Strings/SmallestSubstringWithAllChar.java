
// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
// https://www.youtube.com/watch?v=pbUNTDdxomI&t=733s&ab_channel=Pepcoding
import java.util.HashMap;
import java.util.HashSet;

public class SmallestSubstringWithAllChar {
    public static void main(String[] args) {
        solution("aabcbcdbca");
        solution("bcdbca");
        solution("ba");
        solution("aabaadaa");
        solution("aabaaadabad");
    }

    public static void solution(String str) {
        String result = "";
        HashSet<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            distinctChars.add(str.charAt(i));
        }
        int numberOfDistinctChars = distinctChars.size();
        HashMap<Character, Integer> map = new HashMap<>();
        int lPointer = 0;
        int rPointer = 0;
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire
            while (map.size() < numberOfDistinctChars && rPointer < str.length()) {
                map.put(str.charAt(rPointer), map.getOrDefault(str.charAt(rPointer), 0) + 1);
                rPointer++;
                flag1 = true;
            }
            // store solution and release
            while (map.size() == numberOfDistinctChars && lPointer <= rPointer) {
                String currentWindow = getString(lPointer, rPointer, str); // not required : we can directly compute the
                                                                           // length: (rPointer - lPointer)
                if (result == "" || result.length() > currentWindow.length()) {
                    result = currentWindow;
                }
                map.put(str.charAt(lPointer), map.getOrDefault(str.charAt(lPointer), 0) - 1);
                if (map.get(str.charAt(lPointer)) <= 0) {
                    map.remove(str.charAt(lPointer));
                }
                lPointer++;
                flag2 = true;
            }

            if (!flag1 && !flag2) {
                break;
            }

        }

        System.out.println(result);

    }

    public static String getString(int lPointer, int rPointer, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = lPointer; i < rPointer; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
