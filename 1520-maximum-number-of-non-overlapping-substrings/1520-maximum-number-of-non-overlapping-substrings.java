class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (i != first[ch]) {
                continue;
            }

            int right = checkSubstring(s, i, first, last);
            if (right != -1) {
                if (i > prevEnd) {
                    result.add("");
                }
                prevEnd = right;
                result.set(result.size() - 1, s.substring(i, right + 1));
            }
        }

        return result;
    }

    private int checkSubstring(String s, int i, int[] first, int[] last) {
        int right = last[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            int ch = s.charAt(j) - 'a';
            if (first[ch] < i) {
                return -1;
            }
            right = Math.max(right, last[ch]);
        }
        return right;
    }
}