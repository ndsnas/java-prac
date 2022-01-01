
// https://leetcode.com/problems/sliding-window-maximum/
// https://www.youtube.com/watch?v=tCVOQX3lWeI&ab_channel=Pepcoding
import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(slidingWindowMaximum(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        // 3, 3, 5, 5, 6, 7
    }

    public static int[] slidingWindowMaximum(int nums[], int k) {
        int[] max = new int[nums.length - k + 1];
        int[] nge = new int[nums.length];
        nextGreaterElement(nge, nums);
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (j < i) {
                j = i;
            }
            // keep moving j until the next greater element for i is out of the current
            // window
            // when we reach an element in the window whose nge is out of the window then
            // that element is the greatest among all elements in the window
            while (nge[j] < i + k) {
                j = nge[j];
            }
            max[i] = nums[j];
        }
        return max;
    }

    public static void nextGreaterElement(int[] nge, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            int ele = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] <= ele) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = arr.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}
