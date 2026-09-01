class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] id = new int[m][n];
        int sr = 0, sc = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        int states = 1 << cnt;
        boolean[][][][] vis = new boolean[m][n][energy + 1][states];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int full = states - 1;
        q.offer(new int[]{sr, sc, energy, full});
        vis[sr][sc][energy][full] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];

                if (mask == 0) return moves;
                if (e == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                        classroom[nr].charAt(nc) == 'X') continue;

                    char cell = classroom[nr].charAt(nc);
                    int ne = cell == 'R' ? energy : e - 1;
                    int nm = mask;

                    if (cell == 'L') {
                        nm &= ~(1 << id[nr][nc]);
                    }

                    if (!vis[nr][nc][ne][nm]) {
                        vis[nr][nc][ne][nm] = true;
                        q.offer(new int[]{nr, nc, ne, nm});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}