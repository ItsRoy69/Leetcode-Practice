class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] lastCount = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long sum = 0;
            for (long count : lastCount) {
                sum = (sum + count) % MOD;
            }
            lastCount[idx] = (sum + 1) % MOD;
        }
        
        long total = 0;
        for (long count : lastCount) {
            total = (total + count) % MOD;
        }
        
        return (int) total;
    }
}