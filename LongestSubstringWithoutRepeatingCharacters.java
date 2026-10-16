import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> seen = new HashSet<>();
            int count = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (seen.contains(c)) {
                    break;
                }
                seen.add(c);
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
