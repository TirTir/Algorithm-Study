import java.io.*;

class Solution {
    static int n, answer;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        boolean[] visited = new boolean[n];
        
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(dungeons[i][0] > k) continue;
            
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, visited, count + 1);
            visited[i] = false;
        }
    }
}