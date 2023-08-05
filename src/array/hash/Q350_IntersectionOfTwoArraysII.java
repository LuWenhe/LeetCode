package array.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q350_IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> hashMap2 = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num1 : nums1) {
            if (hashMap.containsKey(num1)) {
                Integer count1 = hashMap.get(num1);
                hashMap.put(num1, ++count1);
            } else {
                hashMap.put(num1, 1);
            }
        }

        for (int num2 : nums2) {
            if (hashMap2.containsKey(num2)) {
                Integer count2 = hashMap2.get(num2);
                hashMap2.put(num2, ++count2);
            } else {
                hashMap2.put(num2, 1);
            }
        }

        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key1 = entry.getKey();
            int value1 = entry.getValue();

            if (hashMap2.containsKey(key1)) {
                int count = value1 < hashMap2.get(key1) ? value1 : hashMap2.get(key1);
                sum += count;
                map.put(key1, count);
            }
        }

        int[] res = new int[sum];
        int j = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                res[j++] = entry.getKey();
            }
        }

        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums1) {
            // 如果HashMap中不存在键,则返回0
            int count = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, count);
        }

        int[] nums = new int[nums1.length];
        int index = 0;

        for (int num : nums2) {
            int count = hashMap.getOrDefault(num, 0);

            if (count > 0) {
                nums[index++] = num;
                count--;
                hashMap.put(num, count);
            }
        }

        return Arrays.copyOf(nums, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 4, 4, 9, 9, 1};
        int[] nums2 = {4, 4, 4, 9};
        int[] nums = new Q350_IntersectionOfTwoArraysII().intersect2(nums1, nums2);

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
