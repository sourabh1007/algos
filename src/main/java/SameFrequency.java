import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SameFrequency {
    public static void main(String[] args) {
        System.out.println(isValid("abbccd")?"YES":"NO");
    }

    private static boolean isValid(String input) {
        char[] inputArr = input.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char inputChar: inputArr) {
            if(!counter.containsKey(inputChar)) {
                counter.put(inputChar, 1);
            } else {
                counter.put(inputChar, counter.get(inputChar) + 1);
            }
        }
        AtomicInteger variable = new AtomicInteger();
        counter.entrySet().stream().forEach(entry -> {
            variable.addAndGet(entry.getValue() % 2);
        });

        return (variable.get() <= 1);
    }
}
