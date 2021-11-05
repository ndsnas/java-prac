public class RecursiveMultiply {
    public static void main(String[] args) {
        // System.out.println(multiply(4, 4));
        System.out.println(multiply2(10, 9));
        System.out.println(multiply2(1, 9));
        System.out.println(multiply2(9, 9));
        System.out.println(multiply2(7, 9));
    }

    static int result = 0;

    public static int multiply(int m, int n) {
        if (n == 1)
            return m;
        return m + multiply(m, n - 1);

    }

    public static int multiply2(int m, int n) {
        if (m == 0)
            return 0;
        if (m == 1)
            return n;

        if (m % 2 == 0) {
            // if m is even, then we just want to divide m by 2 and get the product and then
            // double it.
            int halfProd = multiply2(m >> 1, n);
            return halfProd + halfProd;
        }
        // if m is odd then we can make it even by subtracting 1 from m and add n to the
        // product.
        return multiply2(m - 1, n) + n;
    }
}