import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = 0, sum = sequence[0];
        int min = Integer.MAX_VALUE;
        
         while (right < sequence.length) {
            if (sum == k) {
                int len = right - left;
                if (len < min) {
                    min = len;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            if (sum >= k) {
                sum -= sequence[left++];
            } else {
                right++;
                if (right < sequence.length) sum += sequence[right];
            }
        }
        
        return min == Integer.MAX_VALUE ? new int[]{} : answer;
    }
}