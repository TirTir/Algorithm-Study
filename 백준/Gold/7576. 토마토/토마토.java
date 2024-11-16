import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static int[][] arr;
		static boolean[][] visited;

		static int[] dx = {0, 0, 1, -1};
		static int[] dy = {1, -1, 0, 0};

		static int bfs(int m, int n){
			Deque<int[]> queue = new ArrayDeque<>();
			int answer = 0;
			boolean tomato = true;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
						if (arr[i][j] == 1) {
								queue.addLast(new int[]{i, j});
						} else if (arr[i][j] == 0) {
							tomato = false;
						}
				}
			}

			if (tomato) return 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
						if (arr[i][j] == 1) {
								queue.addLast(new int[]{i, j});
								visited[i][j] = true;
						}
				}
			}

			while (!queue.isEmpty()) {
				int current[] = queue.removeFirst();

				for(int i = 0; i < 4; i++){
					int x = current[0] + dx[i];
					int y = current[1] + dy[i];

					if (x < 0 || x >= m || y < 0 || y >= n) continue;
          if (arr[x][y] != 0) continue;

					arr[x][y] = arr[current[0]][current[1]] + 1;
          queue.addLast(new int[]{x, y});
          answer = Math.max(answer, arr[x][y]);
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
						if (arr[i][j] == 0) return -1;
				}
			}	

		return answer - 1;
	}

    public static void main(String [] args) throws IOException{
			StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[m][n];
			visited = new boolean[m][n];

			for(int i = 0; i < m; i++){
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			System.out.println(bfs(m, n));
    }
}