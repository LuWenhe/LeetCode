package greedy;

import java.util.Arrays;

public class Q455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            // 如果当前饼干满足胃口, 则i和j都要向后移动一位
            if (s[j] >= g[i]) {
                count++;
                i++;
            }

            // 如果当前饼干不满足胃口, 只需要移动饼干
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        int contentChildren = new Q455_AssignCookies().findContentChildren(g, s);
        System.out.println(contentChildren);
    }

}
