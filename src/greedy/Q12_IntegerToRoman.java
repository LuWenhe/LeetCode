package greedy;

public class Q12_IntegerToRoman {

    public String intToRoman(int num) {
        int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < key.length; i++) {
            while (num >= key[i]) {
                stringBuilder.append(values[i]);
                num -= key[i];
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new Q12_IntegerToRoman().intToRoman(4);
        System.out.println(s);
    }

}
