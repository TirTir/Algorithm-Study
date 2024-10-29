import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int N;

    static int dfs(int x, int y){
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{x, y});

        int cnt = 1; //마을 개수
        arr[x][y] = 0; // visit

        while(!stack.isEmpty()){
            int[] cur = stack.removeFirst();
            
            // 4방 탐색
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    continue;
                }

                stack.addLast(new int[]{nx, ny});
                arr[nx][ny] = 0; // visit
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        List<Integer> answer = new LinkedList<>();
        int danji = 0;

        N = Integer.parseInt(br.readLine());

        // 초기화
        arr = new int[N][N];

        // 지도 입력
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(arr[x][y] == 1){
                    answer.add(dfs(x, y));
                    danji++;
                }
            }
        }

        Collections.sort(answer);
		
        StringBuffer sb = new StringBuffer();
        sb.append(danji).append("\n");
        for(int a : answer){
            sb.append(a).append("\n");
        }

        System.out.println(sb.toString());
    }
}