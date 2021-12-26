//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class EquilibriumIndex {
    public static void main(String[] args) {
        System.out.println(equilibriumIndex(new int[] { -7, 1, 5, 2, -4, 3, 0 }));
        System.out.println(equilibriumIndex(new int[] { 1, 1, 1, -1, 1, 1, 1 }));
    }

    public static int equilibriumIndex(int[] arr) {
        // if length of array is less than 2 then no solution.
        if (arr.length < 3) {
            return -1;
        }
        int totalSum = 0;
        //find total sum of the array
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        int leftSum = 0;
        int rightSum = 0;

        // start from index 1 till second last index of the array because first and last indexes can't be equilibrium indexes
        for (int i = 1; i < arr.length - 1; i++) {
            // left sum for the current index i
            leftSum += arr[i - 1];
            // right sum for the current index i will be (total sum - (left sum + element at current index))
            rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
