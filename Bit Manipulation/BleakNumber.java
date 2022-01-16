// https://www.geeksforgeeks.org/check-if-a-number-is-bleak/
// https://www.youtube.com/watch?v=1Jldk8mY6eE&ab_channel=BeenaRathore
public class BleakNumber {
    public static void main(String[] args) {
        solution(6601);
    }

    // if input is 7 then before 7 in a number max set bit can be 3
    // so in x + countSetBit(x) => max countSetBit(x) can be 3
    // so the answer will lie in the range to which we can add 3 and make 7 i.e. 4,
    // 5, 6
    public static void solution(int n) {

        for (int i = n - 1; i >= n - ceilLog(n); i--) {
            if (n == i + countSetBits(i)) {
                System.out.println("Not Bleak :: x = " + i);
                return;
            }
        }
        System.out.println("Bleak");
    }

    public static int ceilLog(int n) {
        int ans = 0;
        n--;
        while (n > 0) {
            n = n / 2;
            ans++;
        }
        return ans;
    }

    public static int countSetBits(int n) {
        int ans = 0;
        while (n > 0) {
            int rightMostSetBitMask = n & -n;
            ans++;
            n -= rightMostSetBitMask;
        }
        return ans;
    }
}
