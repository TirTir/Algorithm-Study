import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int[][][] dp = new int[itemCount + 1][n + 1][m + 1];
        
        for (int i = 0; i <= itemCount; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        dp[0][0][0] = 0;
        
        for (int i = 0; i < itemCount; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dp[i][a][b] == Integer.MAX_VALUE) continue;

                    // A 도둑이 훔치는 경우
                    int newA = a + info[i][0];
                    int newB = b;
                    if (newA < n) {
                        dp[i + 1][newA][newB] = Math.min(dp[i + 1][newA][newB], dp[i][a][b] + info[i][0]);
                    }

                    // B 도둑이 훔치는 경우
                    newA = a;
                    newB = b + info[i][1];
                    if (newB < m) {
                        dp[i + 1][newA][newB] = Math.min(dp[i + 1][newA][newB], dp[i][a][b]);
                    }
                }
            }
        }
        
        int minTraceA = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                minTraceA = Math.min(minTraceA, dp[itemCount][a][b]);
            }
        }
        
        return (minTraceA == Integer.MAX_VALUE) ? -1 : minTraceA;
    }
}