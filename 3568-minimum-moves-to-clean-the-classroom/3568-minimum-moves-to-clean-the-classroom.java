class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int numLitters = litters.size();
        if (numLitters == 0) {
            return 0;
        }
        
        int targetMask = (1 << numLitters) - 1;
        
        int[][][] maxEnergy = new int[m][n][1 << numLitters];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        int initialMask = 0;
        for (int i = 0; i < numLitters; i++) {
            if (litters.get(i)[0] == startX && litters.get(i)[1] == startY) {
                initialMask |= (1 << i);
            }
        }
        
        queue.offer(new int[]{startX, startY, initialMask, energy});
        maxEnergy[startX][startY][initialMask] = energy;
        
        int steps = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == targetMask) {
                    return steps;
                }
                
                if (e == 0) {
                    continue;
                }
                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        int nextEnergy = e - 1;
                        char nextCell = classroom[nr].charAt(nc);
                        
                        if (nextCell == 'R') {
                            nextEnergy = energy;
                        }
                        
                        int nextMask = mask;
                        if (nextCell == 'L') {
                            for (int k = 0; k < numLitters; k++) {
                                if (litters.get(k)[0] == nr && litters.get(k)[1] == nc) {
                                    nextMask |= (1 << k);
                                    break;
                                }
                            }
                        }
                        
                        if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                            maxEnergy[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}