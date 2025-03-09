import java.util.*;

class Solution {
    public long solution(int n) {
        if(n % 2 != 0) return 0;
        
        int index = n / 2;
        long[] dp = new long[index + 1];
        
        dp[1] = 3;
        if (index >= 2) dp[2] = 11;

        for (int i = 3; i <= index; i++) {
            dp[i] = (3 * dp[i - 1]) % 1_000_000_007;

            for (int j = 1; j < i - 1; j++) {
                dp[i] = (dp[i] + 2 * dp[j]) % 1_000_000_007;
            }

            dp[i] = (dp[i] + 2) % 1_000_000_007;
        }
        
        return dp[index];
    }
}