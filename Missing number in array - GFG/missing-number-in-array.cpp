//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;




// } Driver Code Ends
// User function template for C++

class Solution{
  public:
    int missingNumber(vector<int>& array, int n) {
        // Your code goes here
        int xorSum = 0;

        // XOR of all array elements
        for (int i = 0; i < n - 1; i++) {
            xorSum ^= array[i];
        }
    
        // XOR of all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }

    return xorSum;
    }

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        vector<int> array(n - 1);
        for (int i = 0; i < n - 1; ++i) cin >> array[i];
        Solution obj;
        cout << obj.missingNumber(array, n) << "\n";
    }
    return 0;
}
// } Driver Code Ends