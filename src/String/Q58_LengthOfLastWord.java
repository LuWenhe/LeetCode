package String;

public class Q58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            // 如果当前字符为空且字符串长度大于0
            else if (length != 0) {
                break;
            }
        }

        return length;
    }

    public int lengthOfLastWord2(String s) {
        int index = s.length() - 1;

        // 得到最后一个单词的最后一个字母所在的位置
        while (s.charAt(index) == ' ') {
            index--;
        }

        int wordLength = 0;

        // 如果当前字符不为空
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }

        return wordLength;
    }

    public static void main(String[] args) {
        String s = "a";
        int len = new Q58_LengthOfLastWord().lengthOfLastWord(s);
        System.out.println(len);
    }

}
