import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[][] visited;
  static int n;
  
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  static void bfs(int a, int b, char[][] arr){
    Deque<int[]> queue = new ArrayDeque<>();
    queue.addLast(new int[]{a, b});

    char color = arr[a][b];
    visited[a][b] = true;

    while(!queue.isEmpty()){
      int[] cur = queue.removeFirst();

      for(int i = 0; i < 4; i++){
        int x = cur[0] + dx[i];
        int y = cur[1] + dy[i];

        if(x < 0 || x >= n || y < 0 || y >= n) continue;
        if(visited[x][y]) continue;

        if (arr[x][y] == color) {
          visited[x][y] = true;
          queue.add(new int[]{x, y});
        }
      }
    }
  }

  public static void main(String [] args) throws IOException{
    n = Integer.parseInt(br.readLine());
    char[][] arr = new char[n][n];
    char[][] GRarr = new char[n][n];
    
    for(int i = 0; i < n; i++){
      String str = br.readLine();
      for(int j = 0; j < n; j++){
        arr[i][j] = str.charAt(j);
        if (arr[i][j] == 'G') {
          GRarr[i][j] = 'R'; // 적록색약용 배열: G를 R로 변경
        } else {
          GRarr[i][j] = arr[i][j];
        }
      }
    }

    // 적록색약이 아닌 경우
    visited = new boolean[n][n];
    int count1 = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          bfs(i, j, arr);
          count1++;
        }
      }
    }

    // 적록색약인 경우
    visited = new boolean[n][n];
    int count2 = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          bfs(i, j, GRarr);
          count2++;
        }
      }
    }

    System.out.println(count1 + " " + count2);
  }
};
