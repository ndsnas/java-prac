import java.util.*;

public class CanSum {

    private static boolean canSum(int targetSum, List<Integer> numbers) {
        boolean[] table = new boolean[targetSum + 1];
        Arrays.fill(table, false);
        table[0] = true;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == true) {
                for (int j = 0; j < numbers.size(); j++) {
                    int nextIndex = i + numbers.get(j);
                    if (nextIndex < table.length) {
                        table[i + numbers.get(j)] = true;
                        if (table[targetSum] == true) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, List.of(5, 3, 4)));// true
        System.out.println(canSum(7, List.of(5, 3, 4, 7)));// true
        System.out.println(canSum(7, List.of(2, 4)));// false
        System.out.println(canSum(8, List.of(2, 3, 5)));// true
        System.out.println(canSum(300, List.of(7, 14)));// false
    }
}
