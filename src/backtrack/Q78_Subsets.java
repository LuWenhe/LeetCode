package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();     // 记录回溯算法的递归路径

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 5};
        List<List<Integer>> subsets = new Q78_Subsets().subsets(nums);
        System.out.println(subsets);
    }

}
