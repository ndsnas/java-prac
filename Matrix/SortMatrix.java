// https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
// https://www.youtube.com/watch?v=E5WSILx1q0Q&ab_channel=Pepcoding

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 },
        };
        solution(matrix);
    }

    public static class Pair implements Comparable<Pair> {
        int listIndex;
        int valueIndex;
        int val;

        Pair(int listIndex, int valueIndex, int val) {
            this.listIndex = listIndex;
            this.valueIndex = valueIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }

    }

    public static void solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            Pair pair = new Pair(i, 0, matrix[i][0]);
            pq.add(pair);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            result.add(p.val);
            if ((p.valueIndex + 1) < matrix[p.listIndex].length) {
                Pair newPair = new Pair(p.listIndex, p.valueIndex + 1, matrix[p.listIndex][p.valueIndex + 1]);
                pq.add(newPair);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
}
