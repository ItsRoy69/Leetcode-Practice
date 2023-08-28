class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000000007;
        long lcm = (long) a * b / gcd(a, b); // Calculate the LCM
        
        long left = Math.min(a, b);
        long right = (long) Math.min(a, b) * n; // Initial range
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % mod);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
