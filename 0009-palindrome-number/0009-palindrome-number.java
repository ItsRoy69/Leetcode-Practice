class Solution {
    public boolean isPalindrome(int x) {

      if (x < 0) {
            return false; 
        }

        long finalNum = 0;
        int originalX = x;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum = finalNum * 10 + lastDig;
            if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
                return false;
            }
            x = x / 10;
        }
        return originalX == (int)finalNum;
    }
}