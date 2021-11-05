import java.util.*;

public class CanConstruct{
    private static Map<String, Boolean> memo = new HashMap();
    public static void main(String[] args){
        System.out.println(canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeef", List.of(
            "e",
            "ee",
            "eee",
            "eeee"
        )));
    }

    private static boolean canConstruct(String target, List<String> words){
        if(memo.containsKey(target)) return memo.get(target);
        if(target.equals("")) return true;

        for(String word : words){
            if(target.indexOf(word) == 0){ //or startWith() can also be used
                String substring = target.substring(word.length());
                if(canConstruct(substring, words)){
                    memo.put(substring, true);
                    return true;}
            }
        }
        memo.put(target, false);
        return false;
    }
}