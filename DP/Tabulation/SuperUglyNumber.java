
//https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/
//https://www.youtube.com/watch?v=0FMKNDEopR0&t=574s&ab_channel=Pepcoding
import java.util.*;

public class SuperUglyNumber {

    public static class Pair implements Comparable<Pair> {
        int prime;
        int index;
        int val;

        public Pair(int prime, int index, int val) {
            this.prime = prime;
            this.index = index;
            this.val = val;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }

    }

    public static void main(String[] args) {
        System.out.println(getSuperUglyNumber(new int[] { 2, 5 }, 5)); // 8
        System.out.println(getSuperUglyNumber(new int[] { 2, 3, 5 }, 50)); // 243
    }

    public static int getSuperUglyNumber(int[] primes, int n) {
        int[] table = new int[n + 1];
        table[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int prime : primes) {
            pq.add(new Pair(prime, 1, prime));
        }

        for (int i = 2; i <= n;) {
            Pair pair = pq.remove();
            if (table[i - 1] != pair.val) {
                table[i] = pair.val;
                i++;
            }
            pq.add(new Pair(pair.prime, pair.index + 1, pair.prime * table[pair.index + 1]));
        }

        return table[n];
    }
}