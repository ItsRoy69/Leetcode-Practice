class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int MAX = 1e5+1;
        int count[MAX];
        memset(count,0,sizeof(count));
        for(auto &i:nums) {
            count[i]++;
            if(count[i]==2) return i;
        }
        return -1;
    }
};