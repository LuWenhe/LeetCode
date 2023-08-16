package greedy;

import java.util.Arrays;

public class Q561_ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        for (int i = nums.length - 1; i >= 0; i -= 2) {
            sum += Math.min(nums[i], nums[i - 1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        int res = new Q561_ArrayPartition().arrayPairSum(nums);
        System.out.println(res);
    }

}
