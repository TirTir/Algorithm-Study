import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int max = 0;
        
        int base = s / n;
        int num = s % n;
        
        if(base < 1) return new int[]{-1};
        Arrays.fill(answer, base);
        
        for (int i = n - num; i < n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}