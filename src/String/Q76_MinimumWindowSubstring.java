package String;

import java.util.HashMap;

public class Q76_MinimumWindowSubstring {

    /**
     * 如果字符串s=“ABRBC”, 字符串t="ABBC"
     * 最终的window_map={A=1, B=2, C=1}, t_map={A=1, B=2, C=1}
     */
    public String minWindow(String s, String t) {
        // 记录t以及滑动窗口window中字符与个数的映射关系
        HashMap<Character, Integer> window_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        // 将子串t中的字符和出现的次数存在t_map中, 键是字符, 值是出现的次数
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            // 如果HashMap中存在键c1, 则获取对应的值, 如果不存在键c1, 则默认设为0
            Integer tCount = t_map.getOrDefault(c1, 0);
            t_map.put(c1, tCount + 1);
        }

        // 双指针
        int left = 0;
        int right = 0;
        int count = 0;
        // 用于更新满足的窗口window的长度,如果是len一直是MAX_VALUE，说明没有满足的串
        int len = Integer.MAX_VALUE;
        // 用于记录window串的起始位置，则返回 s[start, len]
        int start = 0;

        // 遍历原字符串s
        while (right < s.length()) {
            // c是要移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;

            // 只要字符c是字符串t中出现的字符就更新滑动窗口
            if (t_map.containsKey(c)) {
                Integer windowCount = window_map.getOrDefault(c, 0);
                window_map.put(c, windowCount + 1);

                // 如果字符c在滑动窗口中出现的次数和在字符串t中出现的次数一样, 则说明这个字符符合字符串t的要求
                // count表示如果滑动窗口的每个字符及出现的次数和字符串t中对应的字符相同, 则count++
                if (window_map.get(c).equals(t_map.get(c))) {
                    count++;
                }
            }

            // 收缩window的长度, 只要滑动窗口中的字符及个数满足字符串t在对应的字符
            while (count == t_map.size()) {
                // 更新并记录window的长度,以及window的起始位置start
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d是要移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;

                // 只要字符d是字符串t中出现的字符就更新
                if (t_map.containsKey(d)) {
                    // 如果字符c在滑动窗口中出现的次数和在字符串t中出现的次数一样
                    if (window_map.get(d).equals(t_map.get(d))) {
                        count--;
                    }

                    // 否则, 字符d在滑动窗口中出现的次数减1
                    window_map.put(d, window_map.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String res = new Q76_MinimumWindowSubstring().minWindow("ADRBCA", "ABC");
        System.out.println(res);
    }

}
