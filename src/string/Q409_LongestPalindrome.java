package string;

import java.util.HashMap;
import java.util.Map;

public class Q409_LongestPalindrome {

    /**
     * 统计每个字符出现的个数, 如果是偶数次就全加上, 如果是奇数次就加上再减一, 先保证每次添加的都是字符的偶数次,
     * 最后如果有奇数次字符的就要加上1, 否则不用加
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }

        boolean flag = false;

        for (Integer value : hashMap.values()) {
            // 如果次数是偶数次, 则直接加上该次数
            if (value % 2 == 0) {
                len += value;
            } else {
                flag = true;
                len += value - 1;
            }
        }

        // 如果有奇数次的字符, 需要在最后的长度加上1
        if (flag) {
            return len + 1;
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "aaab";
        int len = new Q409_LongestPalindrome().longestPalindrome(s);
        System.out.println(len);
    }

}
