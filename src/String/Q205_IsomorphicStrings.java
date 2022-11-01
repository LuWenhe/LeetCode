package String;

import java.util.HashMap;
import java.util.Map;

public class Q205_IsomorphicStrings {

    /**
     * 如: s = "ee", t = "ad"
     * 正向的映射为:
     * e -> a
     * g -> d
     * 此时不是同构字符串
     */
    public boolean isIsomorphic(String s, String t) {
        // 需要验证从字符串s->t和t->s两个方向
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // 如果HashMap中存在字符c1
            if (s2t.containsKey(c1)) {
                // 如果字符c1对应的值不是c2, 说明字符c1对应多个映射, 则将返回false
                if (s2t.get(c1) != c2) {
                    return false;
                }
            } else {
                // 如果HashMap中不存在字符c1, 则将字符c1作为键, 字符c2作为值
                s2t.put(c1, c2);
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (s2t.containsKey(c1) && s2t.get(c1) != c2 || t2s.containsKey(c2) && t2s.get(c2) != c1) {
                return false;
            } else {

                s2t.put(c1, c2);
                t2s.put(c2, c1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "cc";
        boolean isomorphic = new Q205_IsomorphicStrings().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

}
