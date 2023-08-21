class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;

        char[] ch = s.toCharArray();

        if (ch.length == 0) {
            return 0;
        }

        if (ch.length == 1) {
            return 1;
        }

        for (int i = 0; i < ch.length; i++) {
            int count = 1;  // Initialize count for the current character
            boolean[] seen = new boolean[256]; // Assuming ASCII characters

            seen[ch[i]] = true;

            for (int j = i + 1; j < ch.length; j++) {
                if (!seen[ch[j]]) {
                    count++;
                    seen[ch[j]] = true;
                } else {
                    break; // Break the inner loop if a repeating character is found
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}