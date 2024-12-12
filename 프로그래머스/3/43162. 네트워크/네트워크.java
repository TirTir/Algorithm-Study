import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static void dfs(int node, int n, int[][] computers){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(node);
        visited[node] = true;
            
        while (!stack.isEmpty()) {
            int cur = stack.removeLast();
                
            for (int i = 0; i < n; i++) {
                if(visited[i] || computers[cur][i] == 0) continue;
                
                stack.addLast(i);
                visited[i] = true;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
         for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
      
        return answer;
    }
}