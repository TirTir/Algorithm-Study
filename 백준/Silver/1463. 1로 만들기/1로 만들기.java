import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solution(int n) {
        int[] dp = new int[n + 1];

        // dp 초기화
        dp[1] = 0;

        for(int i = 2; i <= n; i++){

            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어질 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어질 경우
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
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