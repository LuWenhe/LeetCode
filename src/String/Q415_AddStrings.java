package String;

import java.util.Stack;

public class Q415_AddStrings {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        int sum, carry = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while (len1 >= 0 && len2 >= 0) {
            int a = num1.charAt(len1) - '0';
            int b = num2.charAt(len2) - '0';

            // 拿到所有位数的和
            sum = a + b + carry;
            // 获取个数
            stringBuilder.append(sum % 10);
            // 获取进位
            carry = sum / 10;

            len1--;
            len2--;
        }

        // 当num1还没有遍历完成时, 将num2的对应位当成0
        while (len1 >= 0) {
            sum = num1.charAt(len1) - '0' + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
            len1--;
        }

        // 当num2还没有遍历完成时, 将num1的对应位当成0
        while (len2 >= 0) {
            sum = num2.charAt(len2) - '0' + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
            len2--;
        }

        // 如果最后还有进位, 则将1加入到字符串中
        if (carry == 1) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }

    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        // 当加到最后一位有进位, 如99+9, 需要将进位加入到字符串中
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }

            // 得到个位
            sb.append(carry % 10);
            // 得到进位
            carry /= 10;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "99";
        String str = new Q415_AddStrings().addStrings2(num1, num2);
        System.out.println(str);
    }

}
