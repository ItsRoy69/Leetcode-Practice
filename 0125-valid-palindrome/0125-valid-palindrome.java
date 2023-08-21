class Solution {
    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase().strip().replaceAll("[^a-z0-9]", "");
        for (int i = 0; i < str.length() / 2; i++){
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}