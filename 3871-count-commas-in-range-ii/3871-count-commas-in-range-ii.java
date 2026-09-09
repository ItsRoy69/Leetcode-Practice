class Solution {
    public long countCommas(long n) {
        long commas = 0;
        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            commas += n - threshold + 1;
        }
        return commas;
    }
}