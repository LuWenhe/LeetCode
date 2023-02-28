package Array.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217.存在重复元素
 */
public class Q217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        boolean isRepeat = false;

        for (int num : nums) {
            // 如果hashSet中存在相同的元素, 则add方法返回false
            if (!hashSet.add(num)) {
                isRepeat = true;
                break;
            }
        }

        return isRepeat;
    }

    public boolean containsDuplicate2(int[] nums) {
        boolean isRepeat = false;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (hashMap.get(num) != null) {
                isRepeat = true;
                break;
            }

            hashMap.put(num, 1);
        }

        return isRepeat;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4};
        boolean res = new Q217_ContainsDuplicate().containsDuplicate2(nums);
        System.out.println(res);
    }

}
