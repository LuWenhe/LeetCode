package array.twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 26.删除有序数组中的重复项
 */
public class Q26_RemoveDuplicatesFromSortedArray {

    /**
     * 因为是原地删除, 因此只能对原来的数组进行操作
     */
    public int removeDuplicates(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        // 复制得到新的数组
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        int index = 0;

        for (int num : copyNums) {
            // 如果该元素已经在HashSet中, 则不进行添加
            if (!hashSet.add(num)) {
                continue;
            }

            // 在原来的数组中存放不重复的元素
            nums[index++] = num;
        }

        return hashSet.size();
    }

    /**
     * 使用快慢指针来删除数组中重复的元素
     */
    public int removeDuplicates2(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            // 如果fast指向的值和slow指向的值不同, 说明不是重复的值
            if (nums[slow] != nums[fast]) {
                // 将slow指针向前移动一位
                slow++;
                // 将fast指向的值赋值给slow指向的值
                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println(count);
    }

}
