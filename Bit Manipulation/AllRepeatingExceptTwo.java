// https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
// https://www.youtube.com/watch?v=pnx5JA9LNM4
public class AllRepeatingExceptTwo {

    public static void main(String[] args) {
        solve(new int[] { 5, 5, 6, 6, 9, 8, 7, 7 });
    }

    private static void solve(int[] arr) {
        int xorAll = 0;

        // this will give us the xor of two non-repeating values as other values will
        // get cancelled out during xor operation
        for (int val : arr) {
            xorAll ^= val;
        }

        // this will tell us the rightmost set bit in the xorAll
        // the rightmost set bit will be ON for one of the non-repeating element and off
        // for the other
        // it can be found out by doing AND with 2's complement
        int rightMostSetBitMask = xorAll & -xorAll;
        int x = 0;
        int y = 0;
        // now divide the elements of the array in two parts one which contains the
        // right most bit set and other non-set
        // the non-repeating elements will always appear in different sets
        // and XORing those two sets will give the required numbers
        for (int val : arr) {
            if ((val & rightMostSetBitMask) == 0) {
                x ^= val;
            } else {
                y ^= val;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }

}