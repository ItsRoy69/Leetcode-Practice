class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        for (; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }
}
