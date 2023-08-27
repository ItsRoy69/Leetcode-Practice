class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for (int n=0; n < hours.length;n++){
            if(hours[n]>=target)
            {
                count++;
            }
        }
        return count;
    }
}