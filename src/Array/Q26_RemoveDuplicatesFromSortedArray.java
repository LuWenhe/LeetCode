package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
            // 如果该元素重复, 则跳过
            if (!hashSet.add(num)) {
                continue;
            }

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
            // 如果fast指向的值和slow指向的值不同, 说明不是重复的值, 则将slow指针向前移动一位
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int count = new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates2(nums);
        System.out.println(count);
    }

}
