package Array;

import java.util.Arrays;

public class Q27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        int index = 0;

        for (int num : newNums) {
            if (num == val) {
                continue;
            }

            nums[index++] = num;
        }

        return index;
    }

    /**
     * 使用快慢指针的方式来删除指定的重复元素
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            // 如果fast指针指向的值不等于val, 则将该值赋给slow指针指向的值
            if (nums[fast] != val) {
                // 注意一定是先赋值, 在移动一位
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 3, 3, 4};
        int res = new Q27_RemoveElement().removeElement2(nums, 3);
        System.out.print(res);
    }

}
