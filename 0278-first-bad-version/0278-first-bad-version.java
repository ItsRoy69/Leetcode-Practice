public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        for (int i = 0; left < right; i++) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // If the mid version is bad, search in the left half
                right = mid;
            } else {
                // If the mid version is good, search in the right half
                left = mid + 1;
            }
        }
        
        return left;
    }
}
