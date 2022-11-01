package String;

public class Q345_ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        char[] charArray = s.toCharArray();

        while (left < right) {
            // 如果left指针比总长小并且字符不是元音, 则将left指针向右移动一位
            while (left < len && !isVowel(charArray[left])) {
                left++;
            }

            // 如果right指针大于0并且字符不是元音, 则将right指针向左移动一位
            while (right > 0 && !isVowel(charArray[right])) {
                right--;
            }

            if (left < right) {
                // 交换left和right指针指向的字符
                swap(charArray, left, right);
                // 交换之后需要将left和right指针进行移动
                left++;
                right--;
            }
        }

        return new String(charArray);
    }

    // 是否是元音
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    // 交换两个字符
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String str = new Q345_ReverseVowelsOfAString().reverseVowels(s);
        System.out.println(str);
    }

}
