import java.io.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        
        int[] dp = land[0];
        for (int i = 1; i < n; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = land[i][j] + Math.max(
                    Math.max(dp[(j + 1) % 4], dp[(j + 2) % 4]),
                    dp[(j + 3) % 4]
                );
            }
            dp = temp;
        }

        // 마지막 행에서 최대값 반환
        int answer = 0;
        for (int score : dp) {
            answer = Math.max(answer, score);
        }
        return answer;
    }
}