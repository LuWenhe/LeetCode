package String;

import java.util.HashMap;
import java.util.Map;

public class Q383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            Integer rCount = rMap.getOrDefault(r, 0);
            rMap.put(r, rCount + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            if (rMap.getOrDefault(m, 0) > 0) {
                Integer mCount = rMap.get(m);
                rMap.put(m, mCount - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : rMap.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aaaa";
        boolean res = new Q383_RansomNote().canConstruct(ransomNote, magazine);
        System.out.println(res);
    }

}
