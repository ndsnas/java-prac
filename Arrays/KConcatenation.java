import java.util.*;

public class KConcatenation {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();

        // if k==1 simply return kadane's output
        if (k == 1) {
            System.out.println(kadane(arr));
        } else {
            int arrSum = arrSum(arr);
            int[] k2Arr = copyArray(arr);
            int maxSum = kadane(k2Arr);
            // if sum of input arr is -ve or 0 then max sum will lie in first two copies
            // only
            // because adding other copies will never improve the max sum
            if (arrSum <= 0) {
                System.out.println(maxSum);
            }
            // if sum of input arr is +ve then max sum will lie in first two copies + SUM
            // (not max sum) of k-2 copies as they will improve the max sum
            else {
                System.out.println(maxSum + (k - 2) * arrSum);
            }
        }
    }

    private static int kadane(int[] arr) {
        int curr_best = arr[0];
        int overall_best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (curr_best + arr[i] >= arr[i]) {
                curr_best += arr[i];
            } else {
                curr_best = arr[i];
            }
            if (curr_best > overall_best) {
                overall_best = curr_best;
            }
        }

        return overall_best;
    }

    private static int[] copyArray(int[] arr) {
        int[] newArr = new int[2 * arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i % arr.length];
        }
        return newArr;
    }

    private static int arrSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
