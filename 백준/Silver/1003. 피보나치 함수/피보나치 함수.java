import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int fibonacci(int n){
		if(n == 0){
			return 0;
		} else if (n == 1){
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

  public static void main(String [] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][2];

		dp[0] = new int[]{1, 0};
		dp[1] = new int[]{0, 1};

		for(int i = 2; i <= 40; i++){
			int x = dp[i-1][0] + dp[i-2][0];
			int y = dp[i-1][1] + dp[i-2][1];
			dp[i] = new int[]{x, y};
		}

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
};