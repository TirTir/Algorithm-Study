import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        long right = Arrays.stream(diffs).max().getAsInt();
        int answer = 0;
        
        while(left <= right){
            int mid = left + ((int)right - left) / 2;
            long time = getLevel(diffs, times, mid);
            
            if (time <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    static long getLevel(int[] diffs, int[] times, int level){
        
        long time = 0;
        
        // 첫 번째
        time += getTime(diffs[0], times[0], times[0], level);
        
        for(int i = 1; i < diffs.length; i++){
            time += getTime(diffs[i], times[i], times[i-1], level);
        }
        
        return time;
    }
    
    static long getTime(int diff, int time_cur, int time_prev, int level){
        if(diff <= level) {
            return time_cur;
        } else {
            int n = diff - level;
            return (long)(time_cur + time_prev) * n + time_cur;
        }
    }
}