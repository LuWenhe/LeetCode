package array.Prefix;

public class Q1480_RunningSumOf1dArray {

    /**
     * 使用前缀和的方式
     * <p>
     * runningSum[i] = sum(nums[0]…nums[i])，
     * runningSum[i + 1] = sum(nums[0]…nums[i]) + nums[i + 1] = runningSum[i] + nums[i + 1]
     * <p>
     * preSum[0] = 0;
     * preSum[1] = preSum[0] + nums[0]
     * preSum[2] = preSum[1] + nums[1]
     * ...
     */
    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        return preSum;
    }

    /**
     * 使用遍历的方式
     */
    public int[] runningSum2(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }

            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        Q1480_RunningSumOf1dArray runningSumOf1dArray = new Q1480_RunningSumOf1dArray();
        int[] nums = {3, 1, 2, 10, 1};
        int[] res = runningSumOf1dArray.runningSum(nums);

        for (int r : res) {
            System.out.println(r);
        }
    }

}
