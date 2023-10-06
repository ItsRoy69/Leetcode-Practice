class Solution {
    public int fib(int n) {
      if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fib0 = 0;
        int fib1 = 1;

        for (int i = 2; i <= n; i++) {
            int nextFib = fib0 + fib1;
            fib0 = fib1;
            fib1 = nextFib;
        }

        return fib1;  
    }
}