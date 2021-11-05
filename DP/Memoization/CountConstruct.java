import java.util.*;

public class CountConstruct{
    private static Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args){

        System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeee", List.of(
            "e",
            "ee",
            "eee",
            "eeee"
        )));

    }

    private static Integer countConstruct(String target, List<String> words){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == "") return 1;
        Integer result = 0;
        for(String word : words){
            if(target.indexOf(word) == 0){
                String substring = target.substring(word.length());
                result += countConstruct(substring, words);
            }
        }
        memo.put(target, result);
        return result;
    }
}