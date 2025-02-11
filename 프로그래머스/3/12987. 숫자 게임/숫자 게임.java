import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(A);
        
        for(int b : B) {
            pq.add(b);
        }
        
        int index = 0;
        while(!pq.isEmpty()) {
            int num = pq.remove();
            
            if(A[index] < num) {
                answer ++;
                index ++;
            }
        }
        
        return answer;
    }
}