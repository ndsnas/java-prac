/*
 * https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 */
public class MaximumCircularSubArraySum {

    public static void main(String[] args) {
        solve(new int[] { 8, -8, 9, -9, 10, -11, 12 });
        solve(new int[] { 10, -3, -4, 7, 6, 5, -4, -1 });
        solve(new int[] { -1, 40, -14, 7, 6, 5, -4, -1 });
        solve(new int[] { -2, 4, -1, 4, -1 });
    }

    // input: {a,b,c,d,e,f}
    // There can be 2 cases:
    // I:max sum can lie in between the arr ex: {c,d,e} --> apply simple kadane's
    // algo
    // II: max sum can be overlapping array ex: {e,f,a,b} array --> apply simple
    // kadane's algo to find MIN contiguous array sum and subtract from array sum

    // so the algo can be:
    // X = MAX Sum using Kadane's algo
    // Y = MIN sum using Kadane's algo
    // find Max(X, (arr_sum-Y))
    public static void solve(int[] arr) {
        int arr_sum = 0;
        int curr_max = Integer.MIN_VALUE;
        int overall_max = Integer.MIN_VALUE;
        int curr_min = Integer.MAX_VALUE;
        int overall_min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr_sum += arr[i];
            if (curr_max > 0) {
                curr_max += arr[i];
            } else {
                curr_max = arr[i];
            }
            if (curr_max > overall_max) {
                overall_max = curr_max;
            }

            if (curr_min < 0) {
                curr_min += arr[i];
            } else {
                curr_min = arr[i];
            }
            if (curr_min < overall_min) {
                overall_min = curr_min;
            }
        }
        System.out.println(Math.max(overall_max, arr_sum - overall_min));
    }

}
