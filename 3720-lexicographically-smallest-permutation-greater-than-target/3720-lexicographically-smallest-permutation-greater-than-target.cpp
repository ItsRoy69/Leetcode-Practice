
class Solution {
public:
    string lexGreaterPermutation(string s, string target) {
        int n = s.length();
        vector<int> count(26, 0);
        for (char c : s) {
            count[c - 'a']++;
        }

        vector<int> pref_count = count;
        int max_match = 0;
        while (max_match < n && pref_count[target[max_match] - 'a'] > 0) {
            pref_count[target[max_match] - 'a']--;
            max_match++;
        }

        for (int i = min(n - 1, max_match); i >= 0; i--) {
            vector<int> cur_count = count;
            bool possible = true;
            for (int j = 0; j < i; j++) {
                if (cur_count[target[j] - 'a'] > 0) {
                    cur_count[target[j] - 'a']--;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            for (int c = target[i] - 'a' + 1; c < 26; c++) {
                if (cur_count[c] > 0) {
                    string res = target.substr(0, i);
                    res += (char)('a' + c);
                    cur_count[c]--;

                    for (int ch = 0; ch < 26; ch++) {
                        while (cur_count[ch] > 0) {
                            res += (char)('a' + ch);
                            cur_count[ch]--;
                        }
                    }
                    return res;
                }
            }
        }

        return "";
    }
};