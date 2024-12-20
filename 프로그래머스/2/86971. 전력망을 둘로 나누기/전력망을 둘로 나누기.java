import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 초기화
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양뱡향 그래프 생성
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            
            graph.get(from).remove(Integer.valueOf(to));
            graph.get(to).remove(Integer.valueOf(from));

            visited = new boolean[n + 1];
            int count1 = dfs(from);
            int count2 = n - count1;

            answer = Math.min(answer, Math.abs(count1 - count2));

            // 전선 복구
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        return answer;
    }
    
     static int dfs(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(n);
        visited[n] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int cur = stack.removeLast();

            for (Integer node : graph.get(cur)) {
                if (!visited[node]) {
                    visited[node] = true;
                    stack.addLast(node);
                    count++;
                }
            }
        }

        return count;
    }
}