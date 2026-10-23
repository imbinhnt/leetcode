// Letcode 0004 | Hard | Sat Oct 17 2026

/*
 * Approach: Binary search on partition.
 *
 * The median splits all m + n numbers into a LEFT half and a RIGHT half of
 * (almost) equal size, where every number on the left <= every number on the right.
 *
 * Instead of merging, we only search for the correct split point:
 *   - Cut nums1 at index i (i numbers go to the left half).
 *   - Then nums2 must be cut at j = half - i, where half = (m + n + 1) / 2,
 *     so the left half always has the right size.
 *
 * Because both arrays are already sorted, the left side of each array is
 * already <= its right side. So the split is valid when only the "crossing"
 * pairs are ordered:
 *     left1 <= right2   and   left2 <= right1
 *   (left1 = nums1[i-1], right1 = nums1[i], left2 = nums2[j-1], right2 = nums2[j])
 *
 * If left1 > right2: i is too big, move the cut in nums1 to the left.
 * If left2 > right1: i is too small, move the cut in nums1 to the right.
 *
 * Once the split is valid:
 *   - Odd total:  median = max(left1, left2)
 *   - Even total: median = (max(left1, left2) + min(right1, right2)) / 2
 *
 * Edge cases (cut at the very start or end) use Integer.MIN_VALUE / MAX_VALUE
 * as sentinels, so an empty side never wins a comparison.
 *
 * We always binary search on the SHORTER array, which keeps j in [0, n]
 * and makes the search range as small as possible.
 *
 * Time: O(log(min(m, n))), Space: O(1)
 */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the shorter array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int half = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {
            int i = low + (high - low) / 2; // cut in nums1
            int j = half - i; // cut in nums2

            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                // Valid partition found
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return ((double) Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                high = i - 1; // nums1 cut too far right
            } else {
                low = i + 1; // nums1 cut too far left
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

}

// public class MedianOfTwoSortedArrays {

// // Time: O(m + n), Space: O(m + n)
// public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// int m = nums1.length;
// int n = nums2.length;
// int[] merged = new int[m + n];

// int i = 0, j = 0, k = 0;

// while (i < m && j < n) {
// if (nums1[i] <= nums2[j]) {
// merged[k++] = nums1[i++];
// } else {
// merged[k++] = nums2[j++];
// }
// }

// while (i < m) {
// merged[k++] = nums1[i++];
// }
// while (j < n) {
// merged[k++] = nums2[j++];
// }

// // Find Median
// int total = m + n;
// if (total % 2 == 1) {
// return merged[total / 2];
// }
// return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
// }

// }