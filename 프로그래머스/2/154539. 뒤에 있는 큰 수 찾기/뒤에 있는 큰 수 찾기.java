import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= numbers[i]) {
                stack.removeLast();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(numbers[i]);
        }
        
        return answer;
    }
}