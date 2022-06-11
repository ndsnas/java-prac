// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/submissions/
// https://www.youtube.com/watch?v=3p2fBvxrVQA&ab_channel=AlgorithmsMadeEasy
public class MinimumOperationstoReduceXtoZero{
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
        System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(minOperations(new int[]{5,6,7,8,9}, 4));

    }

    public static int minOperations(int[] nums, int x) {
        int ans=-1;
        int arrSum = 0;
        for(int i=0; i<nums.length; i++){
            arrSum += nums[i];
        }
        // try to maximize the rest of the array size to get the min size of the output
        int sum = arrSum - x;
        
        if(sum < 0){
            return -1;
        }
        
        if(sum == 0){
            return nums.length;
        }
        
        int l=-1;
        int r=-1;
        int tempSum=0;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            while(tempSum < sum && r < nums.length-1){
                r++;
                tempSum += nums[r];
                f1=true;
            }
            
            while(tempSum >= sum && l<=r){
                if(tempSum == sum){
                    ans = Math.max(ans, r-l);
                }
                l++;
                tempSum -= nums[l];
                f2=true;
            }
            
            if(!f1 && !f2){
                break;
            }
        }
        // subtracting rest of the max array from array length to get the answer
        return ans==-1?-1:nums.length-ans;
    }
    
}