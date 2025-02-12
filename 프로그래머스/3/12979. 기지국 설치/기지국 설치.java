class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int i = n;
        int index = stations.length - 1;
        
        while(i > 0) {
            int min = i - w;
            int max = i + w;
            
            if(min < 1) min = 1; // 안전장치
            
            if (index >= 0 && stations[index] >= min) { 
                // 범위 내에 기지국이 있을 경우
                i = stations[index] - w - 1;
                index--;
            } else {
                // 기지국을 설치해야 하는 경우
                answer++;
                i -= 2 * w + 1;
            }
        }
        
        return answer;
    }
}