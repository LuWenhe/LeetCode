package greedy;

public class Q680_ValidPalindromeII {

    /**
     * 如果是字符串"aabbba", 则i和j分别到第1位和第4位, 此时判断bbb和abb字符串是否是回文字符串
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // 如果左右指针不一样, 则验证左指针向前一步或右指针向前一步是否是回文字符串
            if (s.charAt(i) != s.charAt(j)) {
                boolean left = isValid(s, i + 1, j);
                boolean right = isValid(s, i, j - 1);
                return left || right;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean isValid(String s, int i, int j){
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abbca";
        boolean res = new Q680_ValidPalindromeII().validPalindrome(s);
        System.out.println(res);
    }

}
