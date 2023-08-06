class Solution {
    public int specialArray(int[] nums) {
        for (int i = 1; i<= nums.length; i++){
            int count = 0 ; 

            for(int num:nums){
                if(num>=i){
                    count++;
                }
            }
            if(count==i){
                return i;
            }
        }
        return -1;
    }
    
}