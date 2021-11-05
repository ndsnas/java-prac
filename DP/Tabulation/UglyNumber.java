import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        uglyNumber(scn.nextInt());
        scn.close();
    }

    private static void uglyNumber(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for (int i = 2; i <= n; i++) {
            int nextUgly = Math.min(Math.min(arr[p2] * 2, arr[p3] * 3), arr[p5] * 5);
            arr[i] = nextUgly;
            if (nextUgly == arr[p2] * 2) {
                p2++;
            }
            if (nextUgly == arr[p3] * 3) {
                p3++;
            }
            if (nextUgly == arr[p5] * 5) {
                p5++;
            }
        }
        System.out.println(arr[n]);
    }
}
