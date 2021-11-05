import java.util.*;

public class GridTraveler {

    public static void main(String[] args) {
        // System.out.println(gridTraveler(1, 2));
        int[] arr = new int[] { 2, 2, 10, 3, 3, 5, 5 };
        System.out.println(singleDigit(arr));
    }

    private static int gridTraveler(int r, int c) {

        if (r < 0 || c < 0 || (r < 0 && c < 0))
            return 0;

        if (r == 0 || c == 0)
            return 1;

        return gridTraveler(r - 1, c) + gridTraveler(r, c - 1);

    }

    private static int singleDigit(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

}
