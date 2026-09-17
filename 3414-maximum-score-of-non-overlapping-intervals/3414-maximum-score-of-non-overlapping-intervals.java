class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        int[][] sorted = new int[n][4];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            sorted[i][0] = interval.get(0);
            sorted[i][1] = interval.get(1);
            sorted[i][2] = interval.get(2);
            sorted[i][3] = i;              
        }
        
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] lastNonOverlap = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (sorted[mid][1] < sorted[i][0]) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            lastNonOverlap[i] = ans;
        }
        
        long[][] dp = new long[5][n + 1];
        List<Integer>[][] indices = new ArrayList[5][n + 1];
        
        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                indices[k][i] = new ArrayList<>();
            }
        }
        
        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                long weight1 = dp[k][i - 1];
                List<Integer> idx1 = indices[k][i - 1];
                
                int p = lastNonOverlap[i - 1];
                long weight2 = dp[k - 1][p + 1] + sorted[i - 1][2];
                List<Integer> idx2 = new ArrayList<>(indices[k - 1][p + 1]);
                idx2.add(sorted[i - 1][3]);
                Collections.sort(idx2);
                
                if (weight2 > weight1) {
                    dp[k][i] = weight2;
                    indices[k][i] = idx2;
                } else if (weight1 > weight2) {
                    dp[k][i] = weight1;
                    indices[k][i] = idx1;
                } else {
                    dp[k][i] = weight1;
                    if (isLexicographicallySmaller(idx2, idx1)) {
                        indices[k][i] = idx2;
                    } else {
                        indices[k][i] = idx1;
                    }
                }
            }
        }
        
        long maxWeight = -1;
        List<Integer> bestIndices = new ArrayList<>();
        
        for (int k = 1; k <= 4; k++) {
            if (dp[k][n] > maxWeight) {
                maxWeight = dp[k][n];
                bestIndices = indices[k][n];
            } else if (dp[k][n] == maxWeight) {
                if (isLexicographicallySmaller(indices[k][n], bestIndices)) {
                    bestIndices = indices[k][n];
                }
            }
        }
        
        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            result[i] = bestIndices.get(i);
        }
        return result;
    }

    private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
        if (a.isEmpty()) return false;
        if (b.isEmpty()) return true;
        
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}