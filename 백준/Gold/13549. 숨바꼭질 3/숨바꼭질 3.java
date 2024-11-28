import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dx = {-1, 1};
  static boolean[] visited = new boolean[100001];
  
  static int bfs(int n, int k){
    Deque<int[]> queue = new ArrayDeque<>();
    Arrays.fill(visited, false);

    queue.add(new int[]{n, 0});
    visited[n] = true;

    while(!queue.isEmpty()){
      int[] cur = queue.removeFirst();

      if(cur[0] == k) return cur[1];

      // 순간이동
      int temp = cur[0] * 2;
      if (temp <= 100000 && !visited[temp]) {
        queue.addLast(new int[]{temp, cur[1]});
        visited[temp] = true;
      }

      // 일반 거리
      for(int i = 0; i < dx.length; i++){
        int num = cur[0] + dx[i];

        if(num < 0 || num >100000) continue;
        if(visited[num]) continue;

        queue.addLast(new int[]{num, cur[1] + 1});
        visited[num] = true;
      }
    }
    
    return -1;
  }

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int answer = bfs(n, k);
    System.out.println(answer);
	}
};