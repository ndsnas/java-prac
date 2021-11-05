import java.util.*;

public class CountConstruct{
    public static void main(String[] args){

        System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));

    }

    private static Integer countConstruct(String target, List<String> words){
        if(target == "") return 1;
        Integer result = null;
        for(String word : words){
            if(target.indexOf(word) == 0){
                String substring = target.subString(word.length());
                String count = countConstruct(subString, words);
                if(result == null){
                    result = count;
                } 
                else{
                    result += count;
                }
            }
        }
        return result;
    }
}