package Array.TwoPointer;

import java.util.Arrays;

public class Q88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int p1 = 0, p2 = 0, index = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                sorted[index++] = nums1[p1++];
            } else {
                sorted[index++] = nums2[p2++];
            }
        }

        while (p1 < m) {
            sorted[index++] = nums1[p1++];
        }

        while (p2 < n) {
            sorted[index++] = nums2[p2++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new Q88_MergeSortedArray().merge2(nums, m, nums2, n);

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
