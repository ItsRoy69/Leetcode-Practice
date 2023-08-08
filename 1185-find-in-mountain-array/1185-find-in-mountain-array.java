/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Find the index of peak element in mountain array
        int l = 0;
        int r = mountainArr.length() - 1;
        
        while( l <= r ){
            int mid = l + ( ( r - l ) / 2 );
            if( mountainArr.get(mid) > mountainArr.get(mid+1) ) r = mid - 1;
            else l = mid + 1;
        }

        int maxIndex = l;


        //Find the target element left to max element of find in ascending part of array
        l = 0;
        r = maxIndex - 1;

        while( l <= r ){
            int mid = l + ( ( r - l ) / 2 );
            if( mountainArr.get(mid) == target ) return mid;
            if( mountainArr.get(mid) > target ) r = mid - 1;
            else l = mid + 1;
        }


        //Find the target element right to max element of find in descending part of array
        l = maxIndex;
        r = mountainArr.length() - 1;

        while( l <= r ){
            int mid = l + ( ( r - l ) / 2 );
            if( mountainArr.get(mid) == target ) return mid;
            if( mountainArr.get(mid) > target ) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}