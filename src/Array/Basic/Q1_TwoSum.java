package Array.Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class Q1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int []res = new int[2];
        int i = 0;
        int j = i +1;
        boolean isFlag = false;

        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    isFlag =true;
                    break;
                }
            }

            if (isFlag) {
                break;
            }
        }

        res[0] = i;
        res[1] = j;

        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        Q1_TwoSum solution = new Q1_TwoSum();
        int[] a = {3,3};
        int i = 6;

        int[] res = solution.twoSum(a, i);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
