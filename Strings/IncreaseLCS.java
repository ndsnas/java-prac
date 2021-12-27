//https://www.geeksforgeeks.org/count-ways-increase-lcs-length-two-strings-one/
//https://www.geeksforgeeks.org/number-ways-insert-character-increase-lcs-one/
import java.util.*;

public class IncreaseLCS {
    public static void main(String[] args) {
        increaseLCS("abab", "abc");
        increaseLCS("abcabc", "abcd");
    }

    public static void increaseLCS(String str1, String str2) {

        int M = str1.length();
        int N = str2.length();

        // storing positions of every character in str2
        Map<Character, List<Integer>> positionsMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Character c = str2.charAt(i);
            if (positionsMap.containsKey(c)) {
                positionsMap.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                positionsMap.put(c, list);
            }
        }

        // Calculate left LCS dp
        int[][] dpl = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dpl[i][j] = dpl[i - 1][j - 1] + 1;
                } else {
                    dpl[i][j] = Math.max(dpl[i - 1][j], dpl[i][j - 1]);
                }
            }
        }

        // Calculate right LCS dp
        int[][] dpr = new int[M + 1][N + 1];

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dpr[i][j] = dpr[i + 1][j + 1] + 1;
                } else {
                    dpr[i][j] = Math.max(dpr[i + 1][j], dpr[i][j + 1]);
                }
            }
        }

        int lcs = dpl[M][N];
        int ans = 0;

        // taking every distinct char of str2
        for (Character c : positionsMap.keySet()) {

            List<Integer> positionsOfCinStr2 = positionsMap.get(c);
            // taking every position of char c in str2
            for (int j = 0; j < positionsOfCinStr2.size(); j++) {
                // position of char c in str2
                int pos = positionsOfCinStr2.get(j);
                // there can be M+1 positions in str1 where char c can be inserted
                for (int i = 0; i <= M; i++) {
                    // if on inserting character c at pos i in str1
                    // total lcs == lcs(suffix of str1, suffix of str2) + lcs(prefix of str1, prefix of str2)
                    // then we can add 1 to ans
                    if (lcs == dpl[i][pos] + dpr[i][pos + 1]) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
