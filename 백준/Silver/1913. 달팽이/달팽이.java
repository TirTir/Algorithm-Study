import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, num;
    static int[] dr = {1, 0, -1, 0}; // 하 우 상 좌 -> 시계 방향
    static int[] dc = {0, 1, 0, -1};
    static int r = 0, c = 0, d = 0;
    static int answer [];
    static int flag = 0;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine()); // 찾는 거

        int tx=0, ty =0;
        int[][] arr = new int[n][n];
        d= n*n;
        // 입력
        for(int i = d; i > 0; i--){
            arr[r][c] = i;
            if (i == num){
                tx = r;
                ty = c;
            }
            r += dr[flag % 4];
            c += dc[flag % 4];

            if(r >= n || c >= n || r < 0 || c < 0 || arr[r][c] != 0) { //
                r -= dr[flag % 4];
                c -= dc[flag % 4];
                flag++;
                r += dr[flag % 4];
                c += dc[flag % 4];
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append((tx + 1) + " " + (ty + 1));
        System.out.println(sb.toString());
    }
}

