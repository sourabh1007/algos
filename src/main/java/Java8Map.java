import java.util.*;
import java.util.stream.Collectors;

// Sort Hashmap by value
public class Java8Map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("7a", "a");
        map.put("1b", "b");
        map.put("1a", "b");
        map.put("6e", "e");
        map.put("5g", "g");
        map.put("4d", "d");
        map.put("3f", "f");
        map.put("2c", "c");

        System.out.println("--------- Unsorted Map ------------");
        System.out.println(map);

        Map<String, String> mapASCKey = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors
                            .toMap( Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue,
                                    LinkedHashMap::new
                                  )
                        );
        System.out.println("--------- Ascending Key Map ------------");
        System.out.println(mapASCKey);

        Map<String, String> mapDESCKey = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap( Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        System.out.println("--------- Descending Key Map ------------");
        System.out.println(mapDESCKey);

        Map<String, String> mapDESCValue = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap( Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        System.out.println("--------- Descending Value Map ------------");
        System.out.println(mapDESCValue);

        Map<String, String> mapASCValue = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap( Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        System.out.println("--------- Ascending Key Map ------------");
        System.out.println(mapASCValue);
    }
}
