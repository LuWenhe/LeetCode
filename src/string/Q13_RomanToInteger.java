package string;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int n = chars.length;
        int num = 0;

        for (int i = 0; i < n - 1; i++) {
            char c = chars[i];
            char c1 = chars[i + 1];

            if (hashMap.get(c) >= hashMap.get(c1)) {
                num += hashMap.get(c);
            } else {
                num -= hashMap.get(c);
            }
        }

        Integer lastNum = hashMap.get(chars[n - 1]);
        return num + lastNum;
    }

    public static void main(String[] args) {
        String s = "XVI";
        int num = new Q13_RomanToInteger().romanToInt(s);
        System.out.println(num);
    }

}
