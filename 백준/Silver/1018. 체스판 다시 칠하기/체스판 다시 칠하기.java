import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] board;
	static int min = 64;

	static void solution(int x, int y){
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean flag = board[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				if (board[i][j] != flag) {	
					count++;
				}
				
				flag = (!flag);
			}
	
			flag = !flag;
		}

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new boolean[n][m];

		for(int i = 0; i < n; i++){
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'W') {
					board[i][j] = true; // W일 때는 true 
				} else {
					board[i][j] = false; // B일 때는 false
				}
 
			}
		}

		for (int i = 0; i < n-7; i++) {
			for (int j = 0; j < m-7; j++) {
				solution(i, j);
			}
		}

		System.out.println(min);
	}
};