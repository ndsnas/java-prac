import java.util.*;
import java.util.stream.Collectors;
public class Bestsum{
    public static Map<Integer, List<Integer>> memo = new HashMap<>();
    public static void main(String [] args){

        // List<Integer> test1 = bestSum(11, List.of(5));
        // List<Integer> test1 = bestSum(8, List.of(1, 4, 5));
        List<Integer> test1 = bestSum(100, List.of(1, 2, 5, 25));

        if(test1!=null && !test1.isEmpty()) {
            test1.stream().forEach(System.out::println);
        }
        else {System.out.println("NULL");}

    }

    private static List<Integer> bestSum(Integer sum, List<Integer> list){
        if(memo.containsKey(sum)) return memo.get(sum);
        if(sum < 0) return null;
        if(sum == 0) return new ArrayList<Integer>();

        List<Integer> bestSum = null;

        for(Integer ele : list){

            Integer diff = sum - ele;

            var result = bestSum(diff, list);

            var finalList = result!=null ? result.stream().collect(Collectors.toList()) : null;

            if(finalList != null){
                finalList.add(ele);
                // if the current combination is shorter than bestSum combination then update bestSum combination
                if(bestSum == null || finalList.size() < bestSum.size()){
                    bestSum = finalList;
                }
            }

        }
        memo.put(sum, bestSum);
        return bestSum;
    }
}