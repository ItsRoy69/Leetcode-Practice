class Solution {
    public boolean isPalindrome(int x) {
        if (x > 0) {
            int ogX = x;
            int reversedX = 0;

            for (; x != 0; x /= 10) {
                int digit = x % 10;
                reversedX = reversedX * 10 + digit;
            }

            return ogX == reversedX;
        } else if ( x == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
