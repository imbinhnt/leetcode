// Letcode 0004 | Hard | Sat Oct 17 2026

public class MedianOfTwoSortedArrays {

    // Brute force: gộp 2 mảng đã sắp xếp thành 1 mảng rồi lấy trung vị.
    // Time: O(m + n), Space: O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Find Median
        int total = m + n;
        if (total % 2 == 1) {
            return merged[total / 2];
        }
        return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
    }

}