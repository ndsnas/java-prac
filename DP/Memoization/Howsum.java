import java.util.*;
import java.util.stream.Collectors;

class Howsum{
    public static Map<Integer, List<Integer>> memo = new HashMap<>();
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
        List<Integer> test1 = howSum(300, List.of(7, 14));
        // forEach(Integer i : test1){
        //     System.out.println(i);
        // }
        if(test1 != null && !test1.isEmpty()) {test1.stream().forEach(System.out::println);}
        else if(test1 != null && test1.isEmpty()) System.out.println("[]");
        else {System.out.println("NULL");}
        // System.out.println(canSum(7, List.of(5, 3, 3, 7)));
        // System.out.println(canSum(7, List.of(5, 3, 3, 1)));
        // System.out.println(canSum(7, List.of(5, 4, 4, 8)));
        // System.out.println(canSum(4, List.of(1, 1, 1, 1)));
        // System.out.println(canSum(300, List.of(7, 14)));
        // System.out.println(canSum(7, List.of(2, 3)));

    }

    private static List<Integer> howSum(Integer sum,  List<Integer> list){
        if(memo.containsKey(sum)) return memo.get(sum);
        if(sum == 0) return new ArrayList<Integer>();
        if(sum < 0) return null;

        for(Integer ele : list){
            Integer diff = sum-ele;
            var result = howSum(diff, list);
            var finalList =  result!= null ? result.stream().collect(Collectors.toList()) : null;
            memo.put((diff), finalList);
            if(finalList != null) {
                finalList.add(ele);
                return finalList;
            }
        }
        return null;
    }
}