class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingNum = 1;
        for (int num : arr) {
            for (; missingNum < num; missingNum++) {
                k--;
                if (k == 0) {
                    return missingNum;
                }
            }
            missingNum++;
        }
        return missingNum + k - 1;
    }
}
