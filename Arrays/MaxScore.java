// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// https://www.youtube.com/watch?v=_-wTHTPdctA&ab_channel=ProgrammingLivewithLarry
import java.util.*;
public class MaxScore {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3)); // 12
        System.out.println(maxScore(new int[]{2,2,2}, 2)); // 4
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9}, 7)); // 55
    }

    public static int maxScore(int[] cardPoints, int k) {
        if(k==0) return 0;
        int N = cardPoints.length;
        if(k==N) return Arrays.stream(cardPoints).sum();
        if(k==1) return Math.max(cardPoints[0], cardPoints[N-1]);
        if(k==N-1) return Arrays.stream(cardPoints).sum() - Arrays.stream(cardPoints).min().getAsInt();
        int best=0;
        int current=0;
        for(int i=0; i<k; i++){
            current+=cardPoints[i];
        }
        best=current;
        for(int i=0; i < k; i++){
            current += cardPoints[N-1-i];
            current -= cardPoints[k-i-1];
            best=Math.max(best, current);
        }
        return best;
    }
}


//     public static int maxScore(int[] cardPoints, int k) {
//         if(k==0) return 0;
        
//         int totalSum = Arrays.stream(cardPoints).sum();
//         int N = cardPoints.length;
//         if(k==N) return totalSum;
//         if(k==1) return Math.max(cardPoints[0], cardPoints[N-1]);
//         if(k==N-1) return totalSum - Arrays.stream(cardPoints).min().getAsInt();
//         int windowSize = N-k;
//         int bestMin = Integer.MAX_VALUE;
//         int windowSum = 0;
//         int r=0;
//         int l=0;
//         while(true){
//             boolean f1=false;
//             boolean f2=false;
//             while(r-l <= windowSize && r<N){
//                 if(r-l==windowSize){
//                     bestMin = Math.min(bestMin, windowSum);
//                 }
//                 windowSum += cardPoints[r];
//                 r++;
//                 f1=true;
//             }
            
//             while(r-l > windowSize){
//                 windowSum -= cardPoints[l];
//                 l++;
//                 if(r-l==windowSize){
//                     bestMin = Math.min(bestMin, windowSum);
//                 }
//                 f2=true;
//             }
//             if(!f1 && !f2) break;
            
//         }
//         return totalSum-bestMin;
//     }


//     public static Map<String, Integer> dp;
//     public static int maxScore(int[] cardPoints, int k) {
//         if(k==cardPoints.length){
//             return Arrays.stream(cardPoints).sum();
//         }
//         dp = new HashMap<>();
//         return solve(0, 0, cardPoints.length-1, k, cardPoints);
//     }
//     public int solve(int sum, int start, int end, int k, int[] cards){
//         if(k==0){
//             return sum;
//         }
//         String dpKey = start + "-" + end;
//         if(dp.containsKey(dpKey)){
//             return dp.get(dpKey);
//         }
//         else {
//             int maxSum = Math.max(cards[start] + solve(sum, start+1, end, k-1, cards), cards[end] + solve(sum, start, end-1, k-1, cards));
//             dp.put(dpKey, maxSum);
//             return maxSum;
//         } 
//     }