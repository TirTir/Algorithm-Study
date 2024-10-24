import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public long solution(int n){
        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n > 1) dp[2] = 1;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));
    }
}