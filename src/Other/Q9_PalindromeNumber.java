package Other;

public class Q9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        String numberStr = String.valueOf(x);

        // 如果第一个字符不是数字
        if (!Character.isDigit(numberStr.charAt(0))) {
            return false;
        }

        int left = 0, right = numberStr.length() - 1;

        while (left < right) {
            if (numberStr.charAt(left) != numberStr.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * 5     = 5 * 1
     * 54    = 5 * 10 + 4
     * 543   = 54 * 10 + 3
     * 5432
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int reverseNum = 0;
        int num = x;

        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num = num / 10;
        }

        return x == reverseNum;
    }

    public static void main(String[] args) {
        Q9_PalindromeNumber palindromeNumber = new Q9_PalindromeNumber();
        boolean res = palindromeNumber.isPalindrome2(13231);
        System.out.println(res);
    }

}
