//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class RepeatingAndMissingElements {
    public static void main(String[] args) {
        solution(new int[] { 5, 2, 1, 1, 4 });
        solution(new int[] { 5, 1, 1, 2, 4 });
    }

    public static void solution(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            // make value at index abs_val - 1 negative if not visited
            // if the element is visited then at index abs_val - 1 value will already be
            // negative
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            } else {
                System.out.println("Repeating element: " + abs_val);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            // the only positive value index will be the missing number
            if (arr[i] > 0) {
                System.out.println("Missing element: " + (i + 1));
            }
        }
    }
}
