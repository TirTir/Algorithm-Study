import java.util.*;
import java.io.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            // 0부터 n까지
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road) {
            // 양방향
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        int[] way = new int[N + 1];
        Arrays.fill(way, Integer.MAX_VALUE); // 초기화
        way[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1]; // 오름차순
        });
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.remove();
            int num = cur[0]; // 방향
            
            if (cur[1] > way[num]) continue;
            List<int[]> list = graph.get(num);
            
            for(int[] l : list) {
                int fin = l[0]; // 방향
                int weight = cur[1] + l[1]; // 가중치
                
                if (weight < way[fin]) {
                    way[fin] = weight;
                    pq.add(new int[]{fin, weight});
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(way[i] <= K) answer++;
        }

        return answer;
    }
}