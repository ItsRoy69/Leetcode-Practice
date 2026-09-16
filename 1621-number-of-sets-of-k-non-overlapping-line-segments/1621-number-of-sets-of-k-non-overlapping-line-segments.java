class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        
        int N = n + k - 1;
        int R = 2 * k;

        if (R > N) return 0;

        long num = 1;
        long den = 1;

        for (int i = 1; i <= R; i++) {
            num = (num * (N - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (int) ((num * modInverse(den, MOD)) % MOD);
    }

    private long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    private long power(long x, long y, long p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }
}