package array.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 136.只出现一次的数字
 */
public class Q136_SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            // 如果该值在HashMap中没出现过, 则默认的value值为0
            Integer count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++count);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() < 2) {
                return entry.getKey();
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int res = new Q136_SingleNumber().singleNumber(nums);
        System.out.println(res);
    }

}
