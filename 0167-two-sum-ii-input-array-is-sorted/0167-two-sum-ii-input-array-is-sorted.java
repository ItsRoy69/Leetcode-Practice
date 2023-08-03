class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { j + 1, i + 1 }; // Returning the indices of the two numbers (1-based index).
                }
            }
        }
        return new int[] { -1, -1 }; // Return [-1, -1] if no such numbers are found.
    }
}
