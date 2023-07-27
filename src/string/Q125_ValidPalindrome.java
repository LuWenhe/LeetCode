package string;

public class Q125_ValidPalindrome {

    /**
     * 使用双向指针的方法判断是否是回文串
     */
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是数字或者字母,将其转为小写
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        int left = 0, right = stringBuilder.length() - 1;

        // 采用双向指针的方法判断是不是回文串
        while (left <= right) {
            if (stringBuilder.charAt(left) != stringBuilder.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * 使用StringBuilder的reverse()方法判断是否是回文串
     */
    public boolean isPalindrome2(String s) {
        StringBuilder stringBuffer = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }

        // 得到翻转的字符串
        StringBuffer stringBufferRev = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(stringBufferRev.toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new Q125_ValidPalindrome().isPalindrome2(s);
        System.out.println(palindrome);

        char c = 'C';
        char c1 = Character.toLowerCase(c);
        System.out.println(c1);
    }

}
