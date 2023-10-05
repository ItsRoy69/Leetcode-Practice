class Solution {
    public int reverse(int x) {
        long finalNum = 0;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum = finalNum * 10 + lastDig;
            if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int)finalNum;
    }
}
