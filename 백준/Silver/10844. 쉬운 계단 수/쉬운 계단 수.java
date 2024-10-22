import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    static final int MOD = 1000000000;

    public int solution(int n){ 
        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                if (j > 0) dp[i][j] += dp[i-1][j-1];
                if (j < 9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= MOD;
            }
        }

        for(int i = 0; i <= 9; i++){
            answer = (answer + dp[n][i]) % MOD;
        }
        
        return answer;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][11];

        System.out.println(T.solution(n));
    }
}