import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        for(int w : works) {
            pq.add(w);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int p = pq.poll();
            if(p > 0) {
                pq.add(p-1);
                n--;
            }
        }
        
        for(int p : pq) {
            answer += p * p;
        }
        
        return answer;
    }
}