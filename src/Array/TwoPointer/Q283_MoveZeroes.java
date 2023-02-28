package Array.TwoPointer;

/**
 * 283.移动零
 */
public class Q283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 使用快慢指针的方式
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0, fast = 0;

        // 删除数组中的0
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }

            // 若fast指针指向的值为0, 则跳过该值
            fast++;
        }

        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2};
        new Q283_MoveZeroes().moveZeroes2(nums);
    }

}
