package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集Ⅱ
 * <p>
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Q90_SubsetsII {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 需要先排序, 使相同的树枝靠在一起
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    public void backTrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 值相同的树枝, 只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backTrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new Q90_SubsetsII().subsetsWithDup(nums);
        System.out.println(lists);
    }

}
