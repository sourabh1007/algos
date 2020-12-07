import java.util.*;

//Check for balanced paranthesis
public class BalancedParanthesis {
    public static void main(String[] args) throws Exception {
        Scanner inputString = new Scanner(System.in);
        String iStr = inputString.next();

        Map<Character, Character> allowedBraces = new HashMap<>();
        allowedBraces.put('(',')');
        allowedBraces.put('{','}');
        allowedBraces.put('[',']');

        Stack<Character> stack = new Stack<>();

        int strLength = iStr.length();

        for(int count = 0; count < strLength; count++) {
            if(allowedBraces.containsKey(iStr.charAt(count))) {
                stack.push(iStr.charAt(count));
            } else if(allowedBraces.containsValue(iStr.charAt(count))) {
                if(stack.isEmpty()) {
                    throw new Exception("Unbalanced Bracetes");
                }
                Character brace = stack.pop() ;
                if(allowedBraces.get(brace) != iStr.charAt(count)) {
                    throw new Exception("Unbalanced Bracetes");
                }
            }
        }
        if(!stack.isEmpty()) {
            throw new Exception("Unbalanced Bracetes");
        }

        System.out.println("Bracetes are balanced");
    }
}
