import java.io.*;

class Solution {
    static int n, m;
    public int solution(int [][]board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(dp[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
    
}