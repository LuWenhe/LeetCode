package string;

import java.util.HashMap;
import java.util.Map;

public class Q389_FindTheDifference {

    /**
     * 使用HashMap的方法统计元素出现的次数
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();

        // 遍历字符串s, 将字符作为键, 出现次数作为值放在HashMap中
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }

        // 遍历字符串t
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = hashMap.getOrDefault(c, 0);

            // 如果HashMap中存在相同的字符, 则次数减1
            if (count > 0) {
                hashMap.put(c, count - 1);
            }
        }

        // 遍历HashMap
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            // 如果值大于0说明该字符是多出来的
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    /**
     * 使用数组来统计字符串出现的次数
     */
    public char findTheDifference2(String s, String t) {
        int[] cnt = new int[26];

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // 将遍历的字符存入数组
            cnt[ch - 'a']++;
        }

        // 遍历字符串t
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            // 如果数组中存在该字符, 则对应位置的值减1
            cnt[ch - 'a']--;

            // 如果对应位置的值小于0, 说明该字符是添加的字符
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "aa", t = "aaa";
        char c = new Q389_FindTheDifference().findTheDifference2(s, t);
        System.out.println(c);
    }

}
