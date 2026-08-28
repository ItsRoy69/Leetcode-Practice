class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        if (target.length() != n) {
            return "";
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        char centerChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                centerChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) {
            return "";
        }

        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int m = n / 2;

        int maxMatch = 0;
        int[] available = halfCount.clone();
        for (int i = 0; i < m; i++) {
            int idx = target.charAt(i) - 'a';
            if (available[idx] > 0) {
                available[idx]--;
                maxMatch++;
            } else {
                break;
            }
        }

        if (maxMatch == m) {
            String candidate = buildPalindrome(target.substring(0, m), centerChar, n);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = maxMatch; i >= 0; i--) {
            int[] curHalf = halfCount.clone();
            for (int k = 0; k < i; k++) {
                curHalf[target.charAt(k) - 'a']--;
            }

            if (i < m) {
                int startChar = target.charAt(i) - 'a' + 1;
                for (int j = startChar; j < 26; j++) {
                    if (curHalf[j] > 0) {
                        int[] remHalf = curHalf.clone();
                        remHalf[j]--;

                        StringBuilder prefixBuilder = new StringBuilder();
                        prefixBuilder.append(target, 0, i);
                        prefixBuilder.append((char) ('a' + j));

                        for (int k = 0; k < 26; k++) {
                            while (remHalf[k] > 0) {
                                prefixBuilder.append((char) ('a' + k));
                                remHalf[k]--;
                            }
                        }

                        return buildPalindrome(prefixBuilder.toString(), centerChar, n);
                    }
                }
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, char centerChar, int n) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            sb.append(centerChar);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}