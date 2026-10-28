// Leetcode 0001 | Easy | Thu Oct 15 2026

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int key = target - nums[index];

            if (map.containsKey(key)) { // 9-2 = 7 9-7=2
                return new int[] { map.get(key), index };
            } else {
                map.put(nums[index], index); // 7 0
            }

        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6))); // [1, 2]
    }
}
