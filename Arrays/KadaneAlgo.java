public class KadaneAlgo {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] { 4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1 }));
        System.out.println(maxSum(new int[] { -6, -14 }));

    }

    private static int maxSum(int[] arr) {
        int curr_best = arr[0];
        int overall_best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // if adding arr[i] to curr_best will make curr_best optimal or just taking
            // arr[i] standalone will make curr_max optimal?
            if (arr[i] + curr_best > arr[i]) { // or if(curr_best>=0) means if curr_sum is +ve then adding any
                                               // arr[i](+ve or -ve) to curr_best will make it optimal
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
}
