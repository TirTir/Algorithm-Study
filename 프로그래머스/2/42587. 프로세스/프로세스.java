import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            
            if(cur[0] == pq.peek()) {
                pq.poll();
                answer ++;
                
                if(cur[1] == location) {
                    return answer;
                }
                
                continue;
            }
            
            queue.addLast(cur);
        }
        
        return answer;
    }
}