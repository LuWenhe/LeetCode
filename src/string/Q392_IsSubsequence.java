package string;

public class Q392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int sIndex = 0, tIndex = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }

            if (sIndex == s.length()) {
                return true;
            }

            tIndex++;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "", t = "ahbgdc";
        boolean subsequence = new Q392_IsSubsequence().isSubsequence(s, t);
        System.out.println(subsequence);
    }

}
