package other;

public class Q8_StringToInteger {

    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int sign = 1;  // 默认是正数

        if (i < s.length() && charArray[i] == ' ') {
            i++;
        }

        if (i < s.length() && charArray[i] == '+' || charArray[i] == '-') {
            sign = charArray[i] == '+' ? 1 : -1;
            i++;
        }

        if (i < s.length() && Character.isDigit(charArray[i])) {

        }

        return 1;
    }

    public static void main(String[] args) {

    }

}
