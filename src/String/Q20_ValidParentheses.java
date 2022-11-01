package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q20_ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> hashMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == hashMap.get(c)) {
                // 出栈
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]";
        boolean valid = new Q20_ValidParentheses().isValid(s);
        System.out.println(valid);
    }

}
