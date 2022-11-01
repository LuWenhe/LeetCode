package Array;

import java.util.HashSet;
import java.util.Set;

public class Q219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if ((i + j) < nums.length && nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }

            hashSet.add(nums[i]);

            if (hashSet.size() > k) {
                hashSet.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        boolean res = new Q219_ContainsDuplicateII().containsNearbyDuplicate2(nums, k);
        System.out.println(res);
    }

}
