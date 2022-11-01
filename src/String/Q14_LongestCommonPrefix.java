package String;

public class Q14_LongestCommonPrefix {

    /**
     * 纵向扫描
     */
    public String longestCommonPrefix(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();

        // 遍历每一列
        for (int i = 0; i < col; i++) {
            // 得到第0行的第i个字符
            char firstChar = strs[0].charAt(i);

            // 遍历每一行
            for (int j = 1; j < row; j++) {
                // 如果第j行的第i个字符与第0行的第i个字符不等, 或者第j行字符串的长度就是i, 如{"flow", "fl"}
                if (strs[j].length() == i || strs[j].charAt(i) != firstChar) {
                    // 返回第0行的索引从0到i-1的字符串
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "fl", "flight"};
        String str = new Q14_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(str);
    }

}
