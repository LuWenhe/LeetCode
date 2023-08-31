package greedy;

public class Q45_JumpGameII {

    public int jump(int[] nums) {
        // end表示上一次跳跃可到达的范围右边界
        int end = 0, reach = 0, jumps = 0;

        // end表示跳跃之后所在的索引
        for (int i = 0; i < nums.length - 1; i++) {
            // reach表示在i到end中能够跳到的最远距离
            reach = Math.max(nums[i] + i, reach);

            // 到了跳的最远位置的索引, 需要继续跳
            if (end == i) {
                // 跳跃次数
                jumps++;
                // 更新end
                end = reach;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int times = new Q45_JumpGameII().jump(nums);
        System.out.println(times);
    }

}
