class Solution {
    public int findNumbers(int[] nums) {
       int count=0;
        
        for(int num : nums) {
            String s = Integer.toString(num);
            if (s.length() % 2 == 0){
                count++;
            }
        }
        return count;
    }
}