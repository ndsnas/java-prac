import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> list = List.of("abcc", "acbc", "abcd", "bcad", "dbca", "qwre");
        Map<Map<Character, Integer>, List<String>> bigMap = generateMap(list);
        for (List<String> subList : bigMap.values()) {
            System.out.println(subList);
        }

    }

    // count the strings with same frequency map
    // so find the frequency map of a string and add to bigMap
    private static Map<Map<Character, Integer>, List<String>> generateMap(List<String> list) {
        Map<Map<Character, Integer>, List<String>> bigMap = new HashMap<>();

        for (String str : list) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            frequencyMap = generateFrequencyMap(str);
            if (bigMap.containsKey(frequencyMap)) {
                List<String> list1 = bigMap.get(frequencyMap).stream().collect(Collectors.toList());
                list1.add(str);
                bigMap.put(frequencyMap, list1);
            } else {
                List<String> list1 = List.of(str);
                bigMap.put(frequencyMap, list1);
            }
        }

        return bigMap;
    }

    private static Map<Character, Integer> generateFrequencyMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = string.toCharArray();
        for (Character c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}