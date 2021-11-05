public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        String potentialCandidate = potentialCandidate(arr);
        if ("No".equals(potentialCandidate)) {
            System.out.println("No majority element");
        } else {
            if (isMajorityElement(arr, Integer.parseInt(potentialCandidate))) {
                System.out.println(potentialCandidate);
            } else {
                System.out.println("No majority element");
            }
        }
    }

    // Boyer-Moore Majority Voting Algorithm
    private static String potentialCandidate(int[] arr) {
        int candidate = arr[0];
        int occurrence = 1;

        // create pair of each element with distinct elements
        for (int i = 1; i < arr.length; i++) {
            if (candidate == arr[i]) {
                occurrence++;
            } else {
                occurrence--;
                if (occurrence == 0) {
                    candidate = arr[i];
                    occurrence = 1;
                }
            }
        }
        if (occurrence > 0) {
            return candidate + "";
        } else
            return "No";
    }

    private static boolean isMajorityElement(int[] arr, int candidate) {
        int size = arr.length;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == candidate) {
                counter++;
            }
        }
        if (counter >= (size / 2) + 1) {
            return true;
        }
        return false;
    }

}
