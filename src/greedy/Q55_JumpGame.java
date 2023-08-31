package greedy;

public class Q55_JumpGame {

    public boolean canJump(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }

            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        boolean res = new Q55_JumpGame().canJump(nums);
        System.out.println(res);
    }

}
