import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {

    Map<Character, Integer> value = new HashMap(){{
        put('I', 1      );
        put('V', 5      );
        put('X', 10     );
        put('L', 50     );
        put('C', 100    );
        put('D', 500    );
        put('M', 1000   );
    }};

    private int romanToDecimal(String str) {
        int decimalNumber = 0;
        for (int i = 0; i < str.length(); i++) {
            int romanCharacter = value.get(str.charAt(i));
            if (i + 1 < str.length()) {
                int nextRomanCharacter = value.get(str.charAt(i + 1));
                if (romanCharacter >= nextRomanCharacter) {
                    decimalNumber = decimalNumber + romanCharacter;
                } else {
                    decimalNumber = decimalNumber + nextRomanCharacter - romanCharacter;
                    i++;
                }
            } else {
                decimalNumber = decimalNumber + romanCharacter;
            }
        }
        return decimalNumber;
    }

    // Driver Code
    public static void main(String args[]) {
        RomanToNumber ob = new RomanToNumber();
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral"
                + " is "
                + ob.romanToDecimal(str));
    }
}
