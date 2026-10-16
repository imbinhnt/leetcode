
// import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> last = new HashMap<>(); // char -> latest index

        // sliding window technique
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Duplicate inside window: move left past its previous index
            if (last.containsKey(c) && last.get(c) >= left) {
                left = last.get(c) + 1;
            }

            last.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}