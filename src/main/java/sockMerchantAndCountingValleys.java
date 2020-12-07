import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class sockMerchantAndCountingValleys {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        return Long.valueOf(Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .values()
                .stream()
                .map(s-> Math.floor(s/2))
                .collect(Collectors.summarizingInt(s -> s.intValue())).getSum()).intValue();
    }

    public static int countingValleys(int steps, String path) {
        AtomicInteger sum = new AtomicInteger();
        AtomicInteger count = new AtomicInteger();
        path.chars()
                .mapToObj(Character::toChars).forEach(s-> {
                        int temp = sum.get();
                        if(s[0] == 'U') {
                           sum.getAndIncrement();
                        } else if(s[0] == 'D') {
                            sum.getAndDecrement();
                        }
                        if(temp== 0 && sum.get() == -1) {
                            count.getAndIncrement();
                        }
                });

        return Math.abs(count.get());
    }

    public static void main(String[] args) throws IOException {
//      int result = sockMerchant(9, new int[]{10,20,20,10,10,30,50,10,20});
        int result = countingValleys(8, "UDDDUDUU");
        System.out.println(result);
    }
}
