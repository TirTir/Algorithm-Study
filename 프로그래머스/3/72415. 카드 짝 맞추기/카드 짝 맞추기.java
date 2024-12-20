import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}; // 방향키 이동: 오른쪽, 왼쪽, 아래, 위
    static int[] dy = {1, -1, 0, 0};
    static int minMoves;

    public int solution(int[][] board, int r, int c) {
        minMoves = Integer.MAX_VALUE;

        // 카드 번호와 위치 매핑
        Map<Integer, List<int[]>> cardMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    cardMap.putIfAbsent(board[i][j], new ArrayList<>());
                    cardMap.get(board[i][j]).add(new int[]{i, j});
                }
            }
        }

        // 카드 번호 리스트
        List<Integer> cardNumbers = new ArrayList<>(cardMap.keySet());

        // 모든 카드 순열 탐색
        boolean[] visited = new boolean[cardNumbers.size()];
        dfs(board, r, c, cardNumbers, cardMap, visited, 0, 0);

        return minMoves;
    }

    // DFS로 카드 순열 탐색
    private void dfs(int[][] board, int r, int c, List<Integer> cardNumbers, Map<Integer, List<int[]>> cardMap,
                     boolean[] visited, int moves, int depth) {
        if (depth == cardNumbers.size()) {
            minMoves = Math.min(minMoves, moves);
            return;
        }

        for (int i = 0; i < cardNumbers.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int card = cardNumbers.get(i);
                List<int[]> positions = cardMap.get(card);

                int[] pos1 = positions.get(0);
                int[] pos2 = positions.get(1);

                // 첫 번째 -> 두 번째
                int move1 = bfs(board, r, c, pos1[0], pos1[1]) + bfs(board, pos1[0], pos1[1], pos2[0], pos2[1]);
                // 두 번째 -> 첫 번째
                int move2 = bfs(board, r, c, pos2[0], pos2[1]) + bfs(board, pos2[0], pos2[1], pos1[0], pos1[1]);

                // 보드 상태 저장 및 갱신
                board[pos1[0]][pos1[1]] = 0;
                board[pos2[0]][pos2[1]] = 0;

                // 재귀 호출
                dfs(board, pos2[0], pos2[1], cardNumbers, cardMap, visited, moves + move1 + 2, depth + 1);
                dfs(board, pos1[0], pos1[1], cardNumbers, cardMap, visited, moves + move2 + 2, depth + 1);

                // 보드 복원
                board[pos1[0]][pos1[1]] = card;
                board[pos2[0]][pos2[1]] = card;

                visited[i] = false;
            }
        }
    }

    // BFS로 최단 거리 계산
    private int bfs(int[][] board, int startR, int startC, int targetR, int targetC) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[4][4];

        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (r == targetR && c == targetC) {
                return dist;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }

            // Ctrl + 방향키 이동
            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;

                while (true) {
                    int nextR = nr + dx[i];
                    int nextC = nc + dy[i];

                    if (nextR < 0 || nextR >= 4 || nextC < 0 || nextC >= 4) break;
                    if (board[nextR][nextC] != 0) {
                        nr = nextR;
                        nc = nextC;
                        break;
                    }

                    nr = nextR;
                    nc = nextC;
                }

                if (!visited[nr][nc]) {
                    queue.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return Integer.MAX_VALUE; // 도달 불가능한 경우
    }
}