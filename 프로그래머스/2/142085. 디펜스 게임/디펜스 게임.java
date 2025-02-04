import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 1. 매 라운드마다 적의 수를 `PriorityQueue`에 저장
        // 2. 병사가 부족해질 경우, 이전에 방어한 것 중 가장 많은 적을 무적권으로 변경
        // 3. 무적권이 다 떨어지면 즉시 종료
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
            
        for(int e : enemy) {
            pq.add(e);
            n -= e;
            
            // 병사가 부족한 경우
            if(n < 0) {
                if (k > 0) {
                    n += pq.remove();
                    k--;
                } else break; // 무적권 없는 경우
            }
            
            answer++;
        }
        return answer;
    }
}