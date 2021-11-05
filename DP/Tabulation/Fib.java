import java.util.*;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(6));
        // System.out.println(fib(50));
    }

    private static long fib(Integer n) {
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                table[i + 1] += table[i];
            }
            if (i < (n - 1))
                table[i + 2] += table[i];
        }
        return table[n];
    }
}