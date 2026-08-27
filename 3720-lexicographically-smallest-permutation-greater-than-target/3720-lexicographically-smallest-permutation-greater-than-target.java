class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] prefCount = count.clone();
        int maxMatch = 0;
        while (maxMatch < n && prefCount[target.charAt(maxMatch) - 'a'] > 0) {
            prefCount[target.charAt(maxMatch) - 'a']--;
            maxMatch++;
        }
        for (int i = Math.min(n - 1, maxMatch); i >= 0; i--) {
            int[] curCount = count.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                if (curCount[target.charAt(j) - 'a'] > 0) {
                    curCount[target.charAt(j) - 'a']--;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;
            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (curCount[c] > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(target, 0, i);
                    sb.append((char) ('a' + c));
                    curCount[c]--;

                    for (int ch = 0; ch < 26; ch++) {
                        while (curCount[ch] > 0) {
                            sb.append((char) ('a' + ch));
                            curCount[ch]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return "";
    }
}