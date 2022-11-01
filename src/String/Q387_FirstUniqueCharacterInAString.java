package String;

import java.util.HashMap;
import java.util.Map;

public class Q387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char c : charArray) {
            Integer count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.get(charArray[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 字符在字符串中第一次出现的位置
            int firstAppearIndex = s.indexOf(ch);
            // 字符在字符串中最后一次出现的位置
            int lastAppearIndex = s.lastIndexOf(ch);

            // 如果两个位置相同, 则说明该字符只出现了一次
            if (firstAppearIndex == lastAppearIndex) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int index = new Q387_FirstUniqueCharacterInAString().firstUniqChar2("aabbcc");
        System.out.println(index);
    }

}
