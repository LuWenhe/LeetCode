package string;

import java.util.HashMap;
import java.util.Map;

public class Q567_PermutationInString {

    /**
     * 用来判断s2是否包含s1的排列
     * s1="ab", s2="eidbaooo"
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // 将子串s1中的字符和出现的次数存于tMap中, 键是字符, 值是次数
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = tMap.getOrDefault(c, 0);
            tMap.put(c, count + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;

        // 遍历字符串s2
        while (right < s2.length()) {
            // c是要移入窗口的字符
            char c1 = s2.charAt(right);
            // 增大窗口
            right++;

            // 如果字符c1是字符串s1中出现的字符就更新滑动窗口
            if (tMap.containsKey(c1)) {
                Integer windowCount = windowMap.getOrDefault(c1, 0);
                windowMap.put(c1, windowCount + 1);

                if (windowMap.get(c1).equals(tMap.get(c1))) {
                    count++;
                }
            }

            // 收缩window的长度, 保证滑动窗口中字符的个数等于s1中字符的个数
            while ((right - left) >= s1.length()) {
                if (count == tMap.size()) {
                    return true;
                }

                // d是要移出的字符
                char d = s2.charAt(left);
                // 缩小窗口
                left++;

                if (tMap.containsKey(d)) {
                    if (windowMap.get(d).equals(tMap.get(d))) {
                        count--;
                    }

                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "aaaba";
        boolean res = new Q567_PermutationInString().checkInclusion(s1, s2);
        System.out.println(res);
    }

}
