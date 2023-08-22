package array.difference;

import java.util.Arrays;

/**
 * 差分数组工具类
 * diff[i]+=3意味着给nums[i..]所有的元素都加3, 而diff[j+1]-= 3意味着对于nums[j+1..]所有元素减3
 */
public class Difference {

    // 差分数组
    private final int[] diff;

    // 输入一个初始数组，区间操作将在这个数组上进行
    public Difference(int[] nums) {
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给闭区间 [i, j] 增加 val（可以是负数）
    public void increment(int i, int j, int val) {
        diff[i] += val;

        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    // 返回结果数组
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 6, 3, 1};

        // [8, -6, 4, -3, -2]
        Difference difference = new Difference(nums);
        // [8, -3, 4, -3, -5]
        difference.increment(3, 5, 3);
        // [8, 5, 9, 6, 1]
        int[] result = difference.result();

        System.out.println(Arrays.toString(result));
    }

}
