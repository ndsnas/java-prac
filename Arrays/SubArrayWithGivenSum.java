//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        solution(new int[] { 1, 4, 20, 3, 10, 5 }, 15);
        solution(new int[] { 1, 4, 0, 0, 3, 10, 5 }, 7);
        solution(new int[] { 1, 4, 0, 0, 3, 10, 5 }, 10);
        solution(new int[] { 9, 4, 0, 0, 2, 10, 5 }, 1);
        solution(new int[] { 1, 2, 21 }, 21);

        solution(new int[] { 1, 2, 3, 7, 5 }, 12);
        solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15);
        solution(new int[] { 9, 45, 10, 190 }, 225);

    }

    public static void solution(int[] arr, int x) {
        int lPointer = 0;
        int rPointer = 0;
        int sum = 0;
        // sliding window
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            // keep adding until sum is less than x
            while (rPointer < arr.length && sum < x) {
                sum = sum + arr[rPointer++];
                flag1 = true;
            }
            // keep removing from behind
            while (lPointer <= rPointer && sum > x) {
                sum = sum - arr[lPointer++];
                flag2 = true;
            }

            if (!flag1 && !flag2) {
                break;
            }

        }
        if (lPointer >= rPointer || sum != x) {
            System.out.println("not found");
        } else {
            System.out.println(lPointer + " " + (rPointer - 1));
        }
    }
}
