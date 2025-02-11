class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[2];
        
        dp[0] = 1;
        dp[1] = 2;
        
        int cur = 0;
        for(int i = 3; i <= n; i++) {
            cur = (dp[0] + dp[1]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = cur;
        }
        
        return dp[1] % 1000000007;
    }
}