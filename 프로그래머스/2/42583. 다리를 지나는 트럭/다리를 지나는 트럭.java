import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int n = truck_weights.length;
        
        Deque<int[]> queue = new ArrayDeque<>();
        int w = 0, count = 0;
        
        while(count < n || !queue.isEmpty()){
            answer ++;
            
            // 트럭 추가
            if(w < weight && count < n) {
                int addWeight = truck_weights[count];
                if(w + addWeight <= weight){
                    queue.addLast(new int[]{truck_weights[count], bridge_length});
                    w += addWeight; // 총 무게
                    count++; // 트럭 수
                }
            }
            
            int size = queue.size();
            while(size --> 0) {
                int[] cur = queue.removeFirst();
                cur[1] -= 1;
                
                if(cur[1] == 0) {
                    w -= cur[0];
                    continue;
                }
                
                queue.addLast(cur);
            }
        }
        
        return answer;
    }
}