class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;

        for(int i=0; i<accounts.length; i++){
            int temp_wealth = 0;
            for(int j=0; j<accounts[i].length; j++){
                temp_wealth +=accounts[i][j];
            }
            sum = Math.max(sum, temp_wealth);
        }
        return sum;
    }
}