import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 빠른 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1]; // 소요 시간이 짧은 순
            return o1[0] - o2[0]; // 요청 시각이 빠른 순
        });
            
        int currentTime = 0; // 현재 시간
        int process = 0; // 진행중인 작업 번호
        int count = 0; // 작업 개수
        while (count < jobs.length) {
            
            while (process < jobs.length && jobs[process][0] <= currentTime) {
                pq.add(jobs[process]);
                process++;
            }

            if (pq.isEmpty()) {
                currentTime = jobs[process][0];
                continue;
            }
            
            int[] job = pq.poll();
            currentTime += job[1]; // 현재 시간 업데이트
            answer += currentTime - job[0]; // 반환 시간 누적
            count++;
        }
        
        return answer / jobs.length;
    }
}