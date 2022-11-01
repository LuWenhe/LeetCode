package Array;

import java.util.HashMap;
import java.util.Map;

public class Q136_SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
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
