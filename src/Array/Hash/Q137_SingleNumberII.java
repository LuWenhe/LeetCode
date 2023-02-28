package Array.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 137.只出现一次的数字 II
 */
public class Q137_SingleNumberII {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            Integer count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++count);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() < 2) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int res = new Q137_SingleNumberII().singleNumber(nums);
        System.out.println(res);
    }

}
