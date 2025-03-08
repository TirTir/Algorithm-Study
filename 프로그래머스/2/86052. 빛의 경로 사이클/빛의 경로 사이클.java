import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0}; // 좌, 하, 우, 상
    static int[] dy = {0, -1, 0, 1};
    
    static int n, m;
    static boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        int[] answer = {};
        
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[i][j][d]) {
                        list.add(getCycle(grid, i, j, d));
                    }
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static int getCycle(String[] grid, int x, int y, int d) {
        int count = 0;
        int startX = x, startY = y, startD = d;
        
        while (true) {
            if (visited[x][y][d]) break;

            visited[x][y][d] = true;
            count++;

            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;

            char ch = grid[x].charAt(y);
            if (ch == 'L') {
                d = (d + 3) % 4; // 좌회전
            } else if (ch == 'R') {
                d = (d + 1) % 4; // 우회전
            }

            if (x == startX && y == startY && d == startD) break;
        }

        return count;
    }
}