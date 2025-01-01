import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            return o1 - o2;
        });
        
        // 초기화
        for(int s : scoville) {
            pq.add(s);
        }
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            int n = first + (second * 2);
            pq.add(n);
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}