import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[n];
        
        for(int e : elements) {
            queue.add(e);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = queue.removeFirst();
                dp[j] += num;
                set.add(dp[j]);
                queue.addLast(num);
            }
            
            int tmp = queue.removeFirst();
            queue.addLast(tmp);
        }
        
        return set.size();
    }
}