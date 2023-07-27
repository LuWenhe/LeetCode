package string;

public class Q344_ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', 'p'};
        new Q344_ReverseString().reverseString(s);

        for (char ss : s) {
            System.out.print(ss + " ");
        }
    }

}
