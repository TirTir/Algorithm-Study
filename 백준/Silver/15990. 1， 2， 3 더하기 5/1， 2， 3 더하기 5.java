import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 100000;
    static final int MOD = 1000000009;
    static final long[][] dp = new long[MAX + 1][4];

    public static void preCompute() {
        // dp 초기화
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= MAX; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }
    }

    public long solution(int n){
        return (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        preCompute();

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(T.solution(n)).append("\n");
        }

        System.out.print(sb);
    }
}