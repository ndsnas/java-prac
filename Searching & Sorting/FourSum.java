// https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
// https://www.youtube.com/watch?v=hGz0b8L7plI&ab_channel=Pepcoding
import java.util.*;
import java.util.stream.Collectors;
public class FourSum {
    public static void main(String[] args) {
        int arr[] = new int[] { 20, 20, 10, 10, 22, 34, 8 };
        Arrays.sort(arr);
        System.out.println(fourSum(arr, 50, 0));
    }
    // 8 10 10 20 22 34
    public static List<List<Integer>> fourSum(int[] arr, int target, int startIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length - startIndex < 4) {
            return res;
        }

        for (int i = startIndex; i < arr.length - 4; i++) {
            if (i != startIndex && arr[i] == arr[i-1]) {
                continue;
            }
            List<List<Integer>> threeSumList = threeSum(arr, target - arr[i], i + 1);
            for (List<Integer> list : threeSumList) {
                List<Integer> list2 = list.stream().collect(Collectors.toList());
                list2.add(arr[i]);
                res.add(list2);
            }
        }


        return res;
    }
    
    public static List<List<Integer>> threeSum(int[] arr, int target, int startIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length - startIndex < 3) {
            return res;
        }

        for (int i = startIndex; i < arr.length - 3; i++) {
            if (i != startIndex && arr[i] == arr[i-1]) {
                continue;
            }
            List<List<Integer>> twoSumList = twoSum(arr, target - arr[i], i + 1, arr.length - 1);
            for (List<Integer> list : twoSumList) {
                List<Integer> list2 = list.stream().collect(Collectors.toList());
                list2.add(arr[i]);
                res.add(list2);
            }
        }


        return res;
    }
    
    public static List<List<Integer>> twoSum(int[] arr, int target, int startIndex, int endIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length - startIndex < 2) {
            return res;
        }
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            if (left != startIndex && arr[left] == arr[right]) {
                left++;
            }
            else if (arr[left] + arr[right] < target) {
                left++;
            }
            else if (arr[left] + arr[right] > target) {
                right--;
            }
            else {
                List<Integer> subList = List.of(arr[left], arr[right]);
                res.add(subList);
                left++;
                right--;
            }
        }
        return res;
    }
}