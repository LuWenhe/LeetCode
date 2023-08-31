package greedy;

public class Q179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        int n = nums.length;

        // 冒泡排序算法
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String a = strings[j] + strings[j + 1];
                String b = strings[j + 1] + strings[j];

                if (a.compareTo(b) < 0) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        if (strings.length > 0 && strings[0].equals("0")) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String s = new Q179_LargestNumber().largestNumber(nums);
        System.out.println(s);
    }

}
