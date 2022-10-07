class Solution {
public:
    int lengthOfLastWord(string s) {
        //1. Get rid of last spaces
        int i = (int)s.size() - 1;
        while (s[i] == ' ') i--;
        //2. Count the last word
        int result = 0;
        for (i; i >= 0; --i) {
            if(s[i] == ' ')
                return result;
            result++;
        }
        return result;
    }
};