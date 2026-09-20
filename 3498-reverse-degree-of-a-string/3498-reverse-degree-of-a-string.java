class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int revAlphabetIndex = 26 - (s.charAt(i) - 'a');
            total += revAlphabetIndex * (i + 1);
        }
        return total;
    }
}