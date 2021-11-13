
//https://www.geeksforgeeks.org/next-greater-element/
//https://www.youtube.com/watch?v=rSf9vPtKcmI&ab_channel=Pepcoding
import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(List.of(4, 5, 2, 25))));
        System.out.println(Arrays.toString(nextGreaterElement(List.of(13, 7, 6, 12))));

    }

    public static int[] nextGreaterElement(List<Integer> input) {
        int[] output = new int[input.size()];

        Stack<Integer> stack = new Stack<>();

        stack.push(input.get(input.size() - 1));
        output[input.size() - 1] = -1;
        // start from end
        for (int i = input.size() - 2; i >= 0; i--) {
            // keep popping elements from stack until element greater than the element from
            // the input array is not encountered
            while (stack.size() > 0 && stack.peek() < input.get(i)) {
                stack.pop();
            }
            if (stack.size() == 0) {
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }
            stack.push(input.get(i));
        }

        return output;
    }
}