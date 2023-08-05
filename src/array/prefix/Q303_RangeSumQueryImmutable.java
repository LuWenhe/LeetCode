package array.prefix;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class Q303_RangeSumQueryImmutable {

    // preSum[i]表示数组nums从索引0到i的所有元素之和
    private final int[] preSum;

    /**         0   1   2   3   4   5   6
     * nums:   -2,  0,  3, -5,  2, -1
     * preSum:  0, -2, -2,  1, -4, -2, -3
     */
    public Q303_RangeSumQueryImmutable(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];

        // preSum数组从索引为1的位置开始赋值, preSum[i]记录nums[0..i-1]的累加和
//        for (int i = 0; i < nums.length; i++) {
//            preSum[i + 1] = preSum[i] + nums[i];
//        }

        for (int i = 1; i < preSum.length ; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    // 如果想求索引区间[1, 4]内的所有元素之和, 可以通过preSum[5]-preSum[1]得出
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Q303_RangeSumQueryImmutable rangeSumQueryImmutable = new Q303_RangeSumQueryImmutable(nums);
        int sum = rangeSumQueryImmutable.sumRange(0, 2);
        System.out.println(sum);
    }

}
