class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
      sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        vector<int> ans;
        
        int i = 0, j = 0;
        
        while(i < nums1.size() and j < nums2.size())
        {
           if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else
            {
                int temp = nums1[i];
                ans.push_back(nums1[i]);
                while(nums1[i] == temp)
                {i++;
                 if(i >= nums1.size()) break;
                }
                while(nums2[j] == temp)
                {j++;
                 if(j >= nums2.size()) break;
                }
                cout << i << " " << j << endl;
            }
        }
        return ans;
    }
};