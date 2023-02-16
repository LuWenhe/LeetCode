package Array.Basic;

public class Q66_PlusOne {

    /**
     * 1.末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如 45 => 46
     * 2.末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位 %10后为 0，则前一位加 1，直到不为 0 为止，比如 499 => 500
     * 3.末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，需要在第 2 种情况遍历结束的基础上，进行单独处理，比如 999 => 1000
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            // 如果当前位等于0, 说明有进位, 则需要继续遍历计算后一位
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 如果末位有进位, 且一直进位到最前方导致结果多出一位
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Q66_PlusOne plusOne = new Q66_PlusOne();

        int[] digits = {1, 9, 9};
        int[] nums = plusOne.plusOne(digits);

        for (int num : nums) {
            System.out.println(num);
        }
    }
    
}
