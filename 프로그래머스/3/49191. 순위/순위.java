class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] rank = new boolean[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            int w = results[i][0];
            int l = results[i][1];
            rank[w][l] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (rank[i][k] && rank[k][j]) {
                        rank[i][j] = true;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if (rank[i][j] || rank[j][i]) count++;
            }
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}