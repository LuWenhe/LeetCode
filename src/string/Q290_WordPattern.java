package string;

import java.util.HashMap;
import java.util.Map;

public class Q290_WordPattern {

    /**
     * 如 pattern = "abba", s = "dog cat cat dog"
     * <p>
     * a -> dog
     * b -> cat
     * b -> cat
     * a -> dog
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        // 使用空格来分割得到字符串数组
        String[] split = s.split(" ");

        if (pattern.length() != split.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // 得到相同位置的字符和字符串
            char pc = pattern.charAt(i);
            String ss = split[i];

            if (p2s.containsKey(pc) && !p2s.get(pc).equals(ss) || s2p.containsKey(ss) && !s2p.get(ss).equals(pc)) {
                return false;
            } else {
                p2s.put(pc, ss);
                s2p.put(ss, pc);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "aa cc cc aa";
        boolean res = new Q290_WordPattern().wordPattern(pattern, s);
        System.out.println(res);
    }

}
