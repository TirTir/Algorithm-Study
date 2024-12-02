import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] arr;
  static boolean[][] visited;
  static int n, m, answer = 0;

  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  // 'ㅜ' 모양 제외
  static void dfs(int x, int y, int depth, int sum){
    if(depth == 4){
      answer = Math.max(answer, sum);
      return;
    }

    for(int i = 0; i < 4; i++){
      int cur_x = x + dx[i];
      int cur_y = y + dy[i];

      if(cur_x < 0 || cur_x >= n || cur_y < 0 || cur_y >= m) continue;
      if(visited[cur_x][cur_y]) continue;

      visited[cur_x][cur_y] = true;
      dfs(cur_x, cur_y, depth+1, sum+arr[cur_x][cur_y]);
      visited[cur_x][cur_y] = false;
    }

  }

  // 'ㅜ' 모양
  static void makeShape(int x, int y){

    // 1. ㅗ
    if(x >= 0 && y >= 0 && x+1 < n && y+2 < m){
      int sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1];
      answer = Math.max(answer, sum);
    };
    
    // 2. ㅜ
    if(x-1 >= 0 && y >= 0 && x < n && y+2 < m){
      int sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x - 1][y + 1];
      answer = Math.max(answer, sum);
    };

    // 3. ㅏ
    if(x-1 >= 0 && y >= 0 && x+1 < n && y+1 < m){
      int sum = arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x-1][y];
      answer = Math.max(answer, sum);
    };

    // 4. ㅓ
    if(x-1 >= 0 && y-1 >= 0 && x+1 < n && y+1 < m){
      int sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
      answer = Math.max(answer, sum);
    };
  }

  public static void main(String [] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][];
    visited = new boolean[n][m];

    for(int i = 0; i < n; i++){
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        visited[i][j] = true;
        dfs(i, j, 1, arr[i][j]);
        visited[i][j] = false;

        makeShape(i, j);
      }
    }
    System.out.println(answer);
  }
};