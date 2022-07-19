
// https://leetcode.com/problems/pascals-triangle/
import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }

    public static List<List<Integer>> generate(int rows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> first = List.of(1);
        ans.add(first);
        if (rows == 1) {
            return ans;
        }

        for (int i = 1; i < rows; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for (int j = 0; j < ans.get(i - 1).size() - 1; j++) {
                l.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
            }
            l.add(1);
            ans.add(l);
        }
        return ans;
    }
}
