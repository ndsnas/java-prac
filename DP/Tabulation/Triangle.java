// https://leetcode.com/problems/triangle/
// https://www.youtube.com/watch?v=OM1MTokvxs4&ab_channel=NeetCode
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle{
    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<Integer> l1 = List.of(2);
        List<Integer> l2 = List.of(3,4);
        List<Integer> l3 = List.of(6,5,7);
        List<Integer> l4 = List.of(4,1,8,3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        Arrays.fill(dp, 0);
        
        for(int i=triangle.size()-1; i>=0; i--){
            List<Integer> list = new ArrayList<>(triangle.get(i));
            for(int j=0; j<list.size(); j++){
                dp[j] = list.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        
        return dp[0];
    }
}