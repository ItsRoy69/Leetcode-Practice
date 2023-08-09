class Solution {
    int[] nums;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int low = 0, high = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (required_no_of_chunks(mid, m)) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }
    
    private boolean required_no_of_chunks(int mid, int m) {
        int chunks = 0, val = 0;
        for (int i = 0; i < nums.length; i++) {
            val += nums[i];
            if (val > mid) {
                chunks++;
                val = nums[i];
            }
        }
        chunks++;  // Count the last chunk
        return chunks <= m;
    }
}
