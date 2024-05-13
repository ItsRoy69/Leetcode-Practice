class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = (1 << (n - 1)) * m;

        for (int j = 1; j < n; j++) {
            int sameBit = 0;
            for (int i = 0; i < m; i++) {

                if ((grid[i][0] ^ grid[i][j]) == 0) {
                    sameBit++;
                }
            }
            count += (1 << (n - j - 1)) * Math.max(sameBit, m - sameBit);
        }

        return count;
    }
}