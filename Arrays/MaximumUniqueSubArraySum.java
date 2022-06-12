import java.util.*;
public class MaximumUniqueSubArraySum{
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int l=-1;
        int r=-1;
        Map<Integer, Integer> map = new HashMap<>();
        int tempSum=0;
        int sum=0;
        while(true){
            boolean f1=false;
            boolean f2=false;
            while(r<nums.length-1){
                f1=true;
                r++;
                map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
                tempSum+=nums[r];
                if(map.get(nums[r]) > 1){
                    break;
                }
                sum=Math.max(tempSum, sum);
            }
            
            while(l<r && map.get(nums[r]) > 1){
                f2=true;
                l++;
                map.put(nums[l], map.get(nums[l])-1);
                tempSum-=nums[l];
            }
            
            if(!f1 && !f2){
                break;
            }
            
        }
        
        return sum;
    }
}