package greedy;

public class Main {

    public int jump(int[] nums) {
        int len = 0, end = 0, count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            len = Math.max(len, i + nums[i]);

            if (end == i) {
                end = len;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int res = new Main().jump(nums);
        System.out.println(res);
    }

}
