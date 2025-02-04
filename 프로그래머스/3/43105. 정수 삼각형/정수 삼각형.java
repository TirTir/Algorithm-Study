import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int answer = 0;
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j = 1; j < i+1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}