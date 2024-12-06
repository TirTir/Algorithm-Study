import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // 양방향 그래프 생성
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            
            for(int l : graph.get(cur)){
                if(visited[l]) continue;
                
                queue.add(l);
                distance[l] = distance[cur] + 1;
                visited[l] = true;
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            if (distance[i] > max) {
                max = distance[i];
                answer = 1;
            } else if (distance[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}