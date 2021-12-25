// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
// https://www.youtube.com/watch?v=fnbImb8lo88&ab_channel=Pepcoding
// https://www.youtube.com/watch?v=if40LxQ8_Xo&ab_channel=Pepcoding
public class KthSmallestElement {
    // for Kth LARGEST element find (length - k + 1)th smallest element
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
        int k = 6;
        System.out.println(kthSmallestElement(arr, 0, arr.length - 1, k - 1));
    }

    public static int kthSmallestElement(int[] arr, int lo, int hi, int k) {

        int pivot = arr[hi];
        int pi = partition(arr, lo, hi, pivot);

        // pivot element will always go on its correct position
        // if K is less than the pivot element position then it means that Kth smallest
        // element lies on the left of current pivot and vice versa
        if (k < pi) {
            return kthSmallestElement(arr, lo, pi - 1, k);
        } else if (k > pi) {
            return kthSmallestElement(arr, pi + 1, hi, k);
        } else {
            return arr[pi];
        }

    }

    // partitioning the array around the pivot so that the smaller elements are on
    // the left side of the pivot and larger on the right
    // then returning the position of the pivot in the partitioned array
    public static int partition(int[] arr, int lo, int hi, int pivot) {
        System.out.println("Pivot -> " + pivot);
        int i = 0;
        int j = 0;
        // 0 to j-1 -> <= pivot
        // j to i-1 -> > pivot
        // i to end -> unknown
        while (i <= hi) {
            if (pivot >= arr[i]) {
                swap(arr, i, j);
                j++;
                i++;
            } else {
                i++;
            }
        }
        System.out.println("Pivot position -> " + (j - 1));
        return j - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
