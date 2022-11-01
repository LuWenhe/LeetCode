package String;

public class Q434_NumberOfSegmentsInAString {

    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // 当前是第一个字符且第一个位置不为空
            if (i == 0 && s.charAt(i) != ' ') {
                segmentCount++;
                continue;
            }

            // 当前不是第一个字符且前一个字符为空, 后一个字符不为空, 则单词数加1
            if (i >= 1 && s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    public int countSegments2(String s) {
        int count = 0;
        // 当flag为true时表示前一个字符是空格
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 遇到空格则设将flag设为true
            if (c == ' ') {
                flag = true;
            }

            // 前面一个字符是空格且当前字符不为空时
            if (flag && c != ' ') {
                flag = false;
                // 单词数加1
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "Hllo, World";
        int count = new Q434_NumberOfSegmentsInAString().countSegments2(s);
        System.out.println(count);
    }

}
