class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int i = 0;

        while (i <= n - k) {
            boolean found = false;
            for (int len = k; len <= k + 1 && i + len <= n; len++) {
                if (isPalindrome(s, i, i + len - 1)) {
                    count++;
                    i += len;
                    found = true;
                    break;
                }
            }
            if (!found) {
                i++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}