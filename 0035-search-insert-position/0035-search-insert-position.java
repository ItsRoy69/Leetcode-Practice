class Solution {
    public int searchInsert(int[] nums, int target) {
       int i = 0;
       for(; i< nums.length; i++){
           if(target == nums[i])
            return i;
           if (i == 0 && target < nums[i]) 
            return i; 
           if (i > 0 && target > nums[i-1] && target < nums[i])
            return i;  
       } 
       return i;
    }
}