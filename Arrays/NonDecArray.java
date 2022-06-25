// https://leetcode.com/problems/non-decreasing-array/
// https://www.youtube.com/watch?v=zseGV4H2EXQ&ab_channel=TimothyHChang

public class NonDecArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
        System.out.println(checkPossibility(new int[]{100, 1 ,2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {
        
        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        int countDec = 0;
        int countInc = 0;
        
        int N = nums.length;
        
        for(int i=0; i<N; i++){
            if(nums[i] < maxSoFar) countDec++;
            else maxSoFar = Math.max(maxSoFar, nums[i]);
        }
        for(int i=N-1; i>=0; i--){
            if(nums[i] > minSoFar) countInc++;
            else minSoFar = Math.min(minSoFar, nums[i]);
        }
        
        return countDec<=1 || countInc<=1;
    }
}
