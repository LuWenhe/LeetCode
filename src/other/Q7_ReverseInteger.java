package other;

public class Q7_ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            x = -x;
            isNegative = true;
        }

        long num = 0;

        while (x > 0) {
            int unit = x % 10;
            x = x / 10;
            num = num * 10 + unit;
        }

        if (isNegative) {
            num = -num;
        }

        if (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) num;
    }

    public int reverse2(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;

        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(string).reverse();
            String num = stringBuilder.reverse().toString();
            return Integer.parseInt(num) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = -2;
        int reverse = new Q7_ReverseInteger().reverse2(x);
        System.out.println(reverse);
    }

}
