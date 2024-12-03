import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static Deque<int[]> queue = new ArrayDeque<>();
  static final int INF = Integer.MAX_VALUE;
  static int[][][] arr;
  static int m, n, h;

  static int[] dx = {0, 0, 0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dz = {0, 0, 1, -1, 0, 0};

  static void bfs(){
    // { h, n, m }

    while(!queue.isEmpty()){
      int[] cur = queue.removeFirst();
      int x = cur[0], y = cur[1], z = cur[2];

      for(int i = 0; i < 6; i++){
        int a = x + dx[i];
        int b = y + dy[i];
        int c = z + dz[i];

        if(a < 0 || b < 0 || c < 0) continue;
        if(a >= h || b >= n || c >= m) continue;
        if(arr[a][b][c] != 0) continue; // 익은 토마토

        arr[a][b][c] = arr[x][y][z] + 1; // 날짜 갱신
        queue.add(new int[]{a, b, c});
      }
    }
  }
  public static void main(String [] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken()); // 가로
    n = Integer.parseInt(st.nextToken()); // 세로
    h = Integer.parseInt(st.nextToken()); // 높이

    arr = new int[h][n][m];
    boolean flag = true; 

    // 1 -> 익은 토마토  0 -> 익지 않은 토마토  -1 -> 빈 칸
    for(int i = 0; i < h; i++){
      for(int j = 0; j < n; j++){
        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < m; k++){
          int num = Integer.parseInt(st.nextToken());
          // 익은 토마토 모두 추가
          if(num == 1) queue.add(new int[]{i, j, k});
          if(flag && num == 0) flag = false;
          arr[i][j][k] = num;
        }
      }
    }
    
    if(flag) { 
      // 모두 1인 경우 종료
      System.out.println(0);
      return;
    }

    bfs();
    int answer = 0;

    for(int i = 0; i < h; i++){
      for(int j = 0; j < n; j++){
        for(int k = 0; k < m; k++){
          if(arr[i][j][k] == 0){
            System.out.println(-1);
            return;
          } 
          answer = Math.max(answer, arr[i][j][k]);
        }
      }
    }

    System.out.println(answer-1);
  }
};