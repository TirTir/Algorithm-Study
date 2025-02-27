import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        double last = -1;
        
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        for (int[] missile : targets) {
            int s = missile[0];
            int e = missile[1];

            if (last < s) {
                answer++;
                last = e - 0.5;
            }
        }
        
        return answer;
    }
}