import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] arr;
  static int[] color = new int[2];

  static void search(int x, int y, int n){ // 시작점, 길이
    int start = arr[x][y];

    if (n == 1) {
      color[arr[x][y]]++;
      return;
    }

    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (arr[i][j] != start) {
            int half = n / 2;
            // 사분할
            search(x, y, half);
            search(x + half, y, half);
            search(x, y + half, half);
            search(x + half, y + half, half);
            return;
        }
      }
    }
    color[start]++;
  }
  public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];

    for(int i = 0; i < n; i++){
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    search(0, 0, n);

    StringBuffer sb = new StringBuffer();
    sb.append(color[0]).append("\n").append(color[1]);
    System.out.println(sb.toString());
	}
};