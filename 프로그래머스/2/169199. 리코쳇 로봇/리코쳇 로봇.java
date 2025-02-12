import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int len;
    
    public int solution(String[] board) {
        int answer = 0;
        len = board[0].length();
        int[][] map = new int[board.length][len];
        
        int start[] = new int[2];
        int finish[] = new int[2];
        
        // "."은 빈 공간, "R"은 처음 위치, "D"는 장애물 위치, "G"는 목표지점
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < len; j++) {
                char ch = board[i].charAt(j);
                
                if(ch == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if(ch == 'D') {
                    map[i][j] = -1;
                } else if(ch == 'G') {
                    finish[0] = i;
                    finish[1] = j;
                }
            }
        }
        
        answer = bfs(map, start, finish);
        
        return answer;
    }
    
    private static int bfs(int[][] map, int[] start, int[] finish) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][len];
        
        queue.addLast(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            int move = cur[2];
            
            if(cur[0] == finish[0] && cur[1] == finish[1]) {
                return move;
            }
            
            for(int i = 0; i < 4; i++) {
                int x = cur[0];
                int y = cur[1];
                
                // 장애물에 부딪힐때까지
                while (true) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(nx < 0 || nx >= map.length || ny < 0 || ny >= len) break;
                    if(map[nx][ny] == -1) break; // 장애물
                    
                    x = nx;
                    y = ny;
                }
                
                if (visited[x][y]) continue;
                
                queue.addLast(new int[]{x, y, move + 1}); // 현재 위치, 움직인 횟수
                visited[x][y] = true;
            }
        }
        
        // 목표 도달 실패
        return -1;
    }
}