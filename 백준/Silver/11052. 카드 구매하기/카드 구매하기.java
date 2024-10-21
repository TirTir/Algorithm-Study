import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp, price;

    public void solution(int n){
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j-1]);
            }
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        price = Arrays.stream(br.readLine().split(" "))
                      .mapToInt(Integer::parseInt)
                      .toArray();

        T.solution(n);
        System.out.println(dp[n]);
    }
}