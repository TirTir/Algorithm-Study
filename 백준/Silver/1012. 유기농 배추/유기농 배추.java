import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static int n, m;

    static void dfs(int x, int y){
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{x, y});
        arr[x][y] = 0;

        while(!stack.isEmpty()){
            int[] cur = stack.removeLast();

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
                stack.addLast(new int[]{cur_x, cur_y});
            }
        }
    }

    public static void main(String [] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken());

            int answer = 0;
            arr = new int[n][m];

            for(int j = 0; j < k; j++){
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                arr[y][x] = 1;
            }

            for(int x = 0; x < n; x++){
                for(int y = 0; y < m; y++){
                    if(arr[x][y] != 0){
                        dfs(x, y);
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}