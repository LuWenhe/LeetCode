package greedy;

import java.util.Arrays;

public class Q976_LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 6};
        int res = new Q976_LargestPerimeterTriangle().largestPerimeter(nums);
        System.out.println(res);
    }

}
