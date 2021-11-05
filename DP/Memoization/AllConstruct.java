import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AllConstruct {
    private static Map<String, List<List<String>>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl")));

        System.out.println(allConstruct("", List.of("mouse", "dog", "cat")));
        System.out.println(allConstruct("hello", List.of("mouse", "dog", "cat")));
    }

    private static List<List<String>> allConstruct(String target, List<String> words) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target.equals(""))
            return new ArrayList<List<String>>();

        List<List<String>> twoDList = null;

        for (String word : words) {
            if (target.indexOf(word) == 0) {
                String substring = target.substring(word.length());
                List<List<String>> recursionResult = allConstruct(substring, words);
                List<List<String>> finalList = recursionResult != null ? recursionResult.stream()
                        .map(list -> list.stream().collect(Collectors.toList())).collect(Collectors.toList()) : null;
                if (finalList != null && finalList.size() == 0) {
                    finalList.add(List.of(word));
                } else {
                    if (finalList != null)
                        finalList.stream().forEach(list -> list.add(word));
                }
                if (twoDList == null) {
                    twoDList = finalList;
                } else {
                    if (finalList != null) {
                        for (List<String> list : finalList) {
                            twoDList.add(list);
                        }
                    }

                }
            }
        }

        memo.put(target, twoDList);
        return twoDList;

    }

}