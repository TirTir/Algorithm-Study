import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;
        
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{0, 0});
        
        while(!stack.isEmpty()) {
            int[] cur = stack.removeLast();
            int sum = cur[0];
            int count = cur[1];
            
            if(count == n) {
                if(sum == target) answer++;
                continue; 
            }
            
            stack.addLast(new int[]{sum + numbers[count], count + 1});
            stack.addLast(new int[]{sum - numbers[count], count + 1});
        }
        return answer;
    }
}