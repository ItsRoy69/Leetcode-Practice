class Solution {
public:
    typedef long long ll;
    int mySqrt(int x) {
        //sqrt(x) will be in range [1, x]
        //binary search for y such that y * y == x and if not present then find for y such that y * y < x
        ll s = 1;
        ll e = x;
        ll l;
        while(s <= e)
        {
            ll m = (s + e) / 2;
            if(m * m == x)
            {
                return m;
            }
            else if(m * m < x)
            {
                l = m;
                s = m + 1;
            }
            else
            {
                e = m - 1;
            }
        }
        return l;
    }
};
