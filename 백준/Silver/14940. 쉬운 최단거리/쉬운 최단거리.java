import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static int n, m;
  static int[][] arr, visited;

  static void bfs(int x, int y){
    Deque<int[]> queue = new ArrayDeque<>();

    queue.addLast(new int[]{x, y});
    visited[x][y] = 0;

    while(!queue.isEmpty()){
      int[] cur = queue.removeFirst();

      for(int i = 0; i < 4; i++){
        int cur_x = cur[0] + dx[i];
        int cur_y = cur[1] + dy[i];
        
        if(cur_x >= n || cur_x < 0 || cur_y >= m || cur_y < 0) continue;

        if(visited[cur_x][cur_y] != Integer.MAX_VALUE) continue;

        visited[cur_x][cur_y] = visited[cur[0]][cur[1]] + 1;
        queue.addLast(new int[]{cur_x, cur_y});
      }
    }
  }

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(visited[i], Integer.MAX_VALUE);
    }

    int x = 0; 
    int y = 0;

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++){
        int num = Integer.parseInt(st.nextToken());
        if(num == 0){
          visited[i][j] = 0;
        }

        if(num != 2){
          arr[i][j] = num;
        } else { // 목적지 저장
          x = i; 
          y = j;
        }
      }
    }

    bfs(x, y);

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        int answer = visited[i][j];
        if(answer != Integer.MAX_VALUE){
          sb.append(answer).append(" ");
        } else {
          sb.append(-1).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());

	}
};