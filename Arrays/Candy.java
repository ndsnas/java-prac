// https://leetcode.com/problems/candy/
// https://www.youtube.com/watch?v=h6_lIwZYHQw&ab_channel=TECHDOSE

import java.util.*;
public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,0,2}));    //5
        System.out.println(candy(new int[]{1,3,2}));    //4
        System.out.println(candy(new int[]{1,2,2}));    //4
    }

    public static int candy(int[] ratings) {
        int N = ratings.length;
        int[] l2r = new int[N];
        Arrays.fill(l2r, 1);
        
        int[] r2l = new int[N];
        Arrays.fill(r2l, 1);
        
        for(int i=1; i<N; i++){
            if(ratings[i] > ratings[i-1]){
                l2r[i] += l2r[i-1];
            }
        }
        
        for(int i=N-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                r2l[i] += r2l[i+1];
            }
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            ans += Math.max(l2r[i], r2l[i]);
        }
        
        return ans;
    }
}
