import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solution(int n) {
        int[] dp = new int[12];

        // dp 초기화
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]);
        }

        return dp[n];
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int answer = T.solution(n);
            System.out.println(answer);
        }
    }
}