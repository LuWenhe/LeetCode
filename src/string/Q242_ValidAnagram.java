package string;

import java.util.HashMap;
import java.util.Map;

public class Q242_ValidAnagram {

    /**
     * 使用HashMap统计字符出现的次数
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer chCount = hashMap.getOrDefault(ch, 0);
            hashMap.put(ch, chCount + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // 如果HashMap中包含该字符
            if (hashMap.containsKey(ch)) {
                Integer chCount = hashMap.get(ch);

                if (chCount > 0) {
                    hashMap.put(ch, chCount - 1);
                }

                if (chCount - 1 == 0) {
                    count++;
                }
            }
        }

        // 若出现s="ab", t="a"这样的情况则需要判断两个字符串的长度
        return hashMap.size() == count && s.length() == t.length();
    }

    /**
     * 使用数组统计字符出现的次数
     */
    public boolean isAnagram2(String s, String t) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            chars[c - 'a']--;

            if (chars[c - 'a'] < 0) {
                return false;
            }
        }

        // 若出现s="ab", t="a"这样的情况, 也是满足上面的条件, 此时要判断两个字符串的长度是否相同
        return s.length() == t.length();
    }

    public static void main(String[] args) {
        String s = "abv";
        String t = "ab";
        boolean anagram = new Q242_ValidAnagram().isAnagram2(s, t);
        System.out.println(anagram);
    }

}
