package dynatmic;

public class Q91_DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 10];

        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                // 单独解码s[i - 1]
                f[i] = f[i - 1];
            }

            if (i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';

                if (t >= 10 && t <= 26) {
                    // 将s[i - 2] 和 s[i - 1]组合解码
                    f[i] += f[i - 2];
                }
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        String s = "226";
        int res = new Q91_DecodeWays().numDecodings(s);
        System.out.println(res);
    }

}
