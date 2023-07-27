package other;

public class Q67_AddBinary {

    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        int len = Math.max(aLen, bLen);
        int carry = 0;

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder res = new StringBuilder();

        // 将字符串长度较短的那个在前面补0
        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; i++) {
                stringBuilder.append("0");
            }

            b = stringBuilder.append(b).toString();
        }

        if (aLen < bLen) {
            for (int i = 0; i < bLen - aLen; i++) {
                stringBuilder.append("0");
            }

            a = stringBuilder.append(a).toString();
        }

        for (int i = len - 1; i >= 0; i--) {
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';

            // 得到对应位置相加后的结果
            res.append((num1 + num2 + carry) % 2);
            // 得到进位
            carry = (num1 + num2 + carry) / 2;
        }

        if (carry > 0) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;

        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;

            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }

            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }

//            sum = sum + (i >= 0 ? a.charAt(i) - '0' : 0);
//            sum = sum + j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Q67_AddBinary addBinary = new Q67_AddBinary();
        String s = addBinary.addBinary("111", "1");
        System.out.println(s);
    }

}
