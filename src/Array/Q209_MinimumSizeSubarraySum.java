package Array;

public class Q209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, len = nums.length;
        boolean isFlag = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += nums[k];

                    if (sum >= target && j - i < len) {
                        len = j - i + 1;
                        isFlag = true;
                    }
                }

                sum = 0;
            }
        }

        if (!isFlag) {
            return 0;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1 ,1, 1, 1, 1};
        int len = new Q209_MinimumSizeSubarraySum().minSubArrayLen(11, nums);
        System.out.println(len);
    }

}
