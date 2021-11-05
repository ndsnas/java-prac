import java.util.*;

class Cansum{
    public static Map<Integer, Boolean> memo = new HashMap<>();
    public static void main(String[] args){
        // System.out.println("Insert Sum :: ");
        // Scanner sc = new Scanner(System.in);
        // Integer sum = sc.nextInt();
        // List<Integer> list = new ArrayList<Integer>();
        // System.out.println("Input size :: ");
        // Integer size = sc.nextInt();
        // System.out.println("Input Array :: ");
        // for(int i = 0; i<size; i++){
        //     list.add(sc.nextInt());
        // }

        System.out.println(canSum(7, List.of(5, 3, 4, 7)));
        System.out.println(canSum(7, List.of(5, 3, 3, 7)));
        System.out.println(canSum(7, List.of(5, 3, 3, 1)));
        System.out.println(canSum(7, List.of(5, 4, 4, 8)));
        System.out.println(canSum(4, List.of(1, 1, 1, 1)));
        System.out.println(canSum(300, List.of(7, 14)));
        System.out.println(canSum(7, List.of(2, 3)));

    }

    private static boolean canSum(int sum,  List<Integer> list){
        if(memo.containsKey(sum)) return memo.get(sum);
        if(sum == 0) return true;
        if(sum < 0) return false;

        for(Integer ele : list){
            boolean result = canSum((sum - ele), list);
            memo.put((sum - ele), result);
            if(result) return true;
        }
        return false;
    }
}