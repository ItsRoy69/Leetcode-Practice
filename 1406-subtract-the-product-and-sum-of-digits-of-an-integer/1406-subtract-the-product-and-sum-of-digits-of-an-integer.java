class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        for (; n != 0; n /= 10) {
            int rem = n % 10;
            prod *= rem;
            sum += rem;
        }
        return prod - sum;
    }
}
