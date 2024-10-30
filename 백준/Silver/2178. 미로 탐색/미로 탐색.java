import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static int[][] distance;
    static int n, m;
    static int cnt = 0;

    static int bfs(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{x, y});
        distance[x][y] = 1; // 거리 정보를 저장

        while(!queue.isEmpty()){
            int cur[] = queue.removeFirst();
            
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return distance[cur[0]][cur[1]];
            }

            for(int i = 0; i < 4; i++){
                int cur_x = cur[0] + dx[i];
                int cur_y = cur[1] + dy[i];

                if(cur_x < 0 || cur_x >= n || cur_y < 0 || cur_y >= m){
                    continue;
                }

                if(arr[cur_x][cur_y] == 0){
                    continue;
                }

                arr[cur_x][cur_y] = 0;
                distance[cur_x][cur_y] = distance[cur[0]][cur[1]] + 1;
                queue.addLast(new int[]{cur_x, cur_y});
                cnt++;
            }
        }

        return 0;
    }

    public static void main(String [] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        distance = new int[n][m];

        for(int i = 0; i < n; i++){
            arr[i] = Arrays.stream(br.readLine().split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        int answer = bfs(0, 0);
        System.out.println(answer);
    }
}