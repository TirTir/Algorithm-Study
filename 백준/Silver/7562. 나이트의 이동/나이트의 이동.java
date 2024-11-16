import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static int[][] arr;
		static int l;

		static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

		static int bfs(int[] n, int[] m){
			Deque<int[]> queue = new ArrayDeque<>();
			queue.addLast(new int[]{n[0], n[1]});
			arr[n[0]][n[1]] = 1;
			
			while(!queue.isEmpty()){
				int[] cur = queue.removeFirst();

				if(cur[0] == m[0] && cur[1] == m[1]){
					return arr[cur[0]][cur[1]] - 1;
				}

				for(int i = 0; i < 8; i++){
					int x = cur[0] + dx[i];
					int y = cur[1] + dy[i];

					if (x < 0 || x >= l || y < 0 || y >= l) continue;
          if (arr[x][y] != 0) continue;

          arr[x][y] = arr[cur[0]][cur[1]] + 1;
          queue.addLast(new int[]{x, y});
				}
			}

			return -1;
		}

    public static void main(String [] args) throws IOException{
			int t = Integer.parseInt(br.readLine());

			StringBuffer sb = new StringBuffer();
			while(t --> 0){
				l = Integer.parseInt(br.readLine());
				arr = new int[l][l];

				int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[] m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				sb.append(bfs(n, m)).append("\n");
			}

			System.out.println(sb.toString());
    }
}