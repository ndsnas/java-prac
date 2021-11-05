import java.util.*;

public class Way{
    public static Map<String, Long> memo = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println("Size of matrix :: " + n + " " + m);
        System.out.println("Solution :: " + totalWays(n-1, m-1));
    }

    private static long totalWays(long n, long m){
        if(memo.containsKey(String.valueOf(n) + "," + String.valueOf(m))) return memo.get(String.valueOf(n) + "," + String.valueOf(m));
        else if(memo.containsKey(String.valueOf(m) + "," + String.valueOf(n))) return memo.get(String.valueOf(m) + "," + String.valueOf(n));
        if(n == 0 || m==0) return 1;
        else
        {
            memo.put(String.valueOf(n) + "," +  String.valueOf(m), totalWays(n-1, m) + totalWays(n, m-1));
        }
        System.out.println(Arrays.asList(memo));
        return memo.get(String.valueOf(n) + "," + String.valueOf(m));
    }
}
