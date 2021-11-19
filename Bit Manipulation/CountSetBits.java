//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
//https://www.youtube.com/watch?v=I475waWiTK4&t=221s
public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(4));
        System.out.println(countSetBits(7));
        System.out.println(countSetBits(3));
    }

    // Brian Kernighan’s Algorithm
    public static int countSetBits(int num) {
        int counter = 0;
        // find rightmost set bit mask and subtract it from the number until it is zero
        while (num > 0) {
            int rightMostSetBitMask = num & -num;
            counter++;
            num -= rightMostSetBitMask;
        }

        return counter;
    }
}
