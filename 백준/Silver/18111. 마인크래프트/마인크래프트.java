import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, B;
  static int[][] ground;

  static String solution(int max, int min){
    int min_time = Integer.MAX_VALUE;
    int height = 0;

    for(int h = min; h <= max; h++){
      int time = 0;
      int inven = B; // 초기화

      for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
          int temp = ground[i][j] - h;

          if (temp > 0) { // 블록 제거
            time += temp * 2;
            inven += temp;
          } else if (temp < 0) { // 블록 추가
            time -= temp;
            inven += temp;
          }
        }
      }

      if (inven < 0) continue;
      if (time < min_time || (time == min_time && h > height)) {
        min_time = time;
        height = h;
      }
    }

    StringBuffer sb = new StringBuffer();
    sb.append(min_time).append(" ").append(height);

    return sb.toString();
  }
  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    ground = new int[N][M];
    int max = 0;
    int min = Integer.MAX_VALUE;

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        ground[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, ground[i][j]);
        min = Math.min(min, ground[i][j]);
      }
    }

    System.out.println(solution(max, min));
  }
};