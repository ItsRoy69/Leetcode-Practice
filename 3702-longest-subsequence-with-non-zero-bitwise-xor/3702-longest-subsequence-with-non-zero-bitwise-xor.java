class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (!hasNonZero) {
            return 0;
        }

        return totalXor != 0 ? nums.length : nums.length - 1;
    }
}