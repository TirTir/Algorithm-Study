import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int index = 0;
        for (int box = 1; box <= order.length; box++) {
            if (order[index] != box) {
                stack.addLast(box);
            } else {
                answer++;
                index++;
                
                while (!stack.isEmpty() && stack.peekLast() == order[index]) {
                    stack.removeLast();
                    answer++;
                    index++;
                }
            }
        }
        
        return answer;
    }
}