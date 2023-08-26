class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length]; 
        int i = 0, j = 0, k = 0;
        for (; i < nums1.length && j < nums2.length; k++) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
        }

        for (; i < nums1.length; i++, k++) {
            merged[k] = nums1[i];
        }

        for (; j < nums2.length; j++, k++) {
            merged[k] = nums2[j];
        }

        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        } else {
            return merged[total / 2];
        }
    }
}