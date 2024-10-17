import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];

        // dp 초기화
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        return dp[n];
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        int answer = T.solution(n);
        System.out.println(answer);
    }
}