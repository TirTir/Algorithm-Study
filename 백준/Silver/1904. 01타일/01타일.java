import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public int solution(int n){
        dp[1] = 1;
        if(n > 1) dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        return dp[n];
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        System.out.println(T.solution(n));
    }
}