public class FloorCeil {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 8, 10, 10, 12, 19 };
        floorCeil(arr, 0, arr.length - 1, 20);
    }

    public static void floorCeil(int arr[], int low, int high, int x) {

        int mid = (low + high) / 2;

        if (x == arr[mid]) {
            System.out.println("Floor " + arr[mid]);
            System.out.println("Ceil " + arr[mid]);
            return;
        } else if (x < arr[mid]) {
            if (mid - 1 < 0) {
                System.out.println("Floor doesn't exist");
                System.out.println("Ceil " + arr[mid]);
                return;
            }
            if (x > arr[mid - 1]) {
                System.out.println("Floor " + arr[mid - 1]);
                System.out.println("Ceil " + arr[mid]);
            } else {
                floorCeil(arr, low, mid - 1, x);
            }
        } else {
            if (mid + 1 >= arr.length) {
                System.out.println("Floor " + arr[mid]);
                System.out.println("Ceil doesn't exist");
                return;
            }
            if (x < arr[mid + 1]) {
                System.out.println("Floor " + arr[mid]);
                System.out.println("Ceil " + arr[mid + 1]);
            } else {
                floorCeil(arr, mid + 1, high, x);
            }
        }
    }
}
