import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < number.length(); i++) {
            char num = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < num) {
                stack.removeLast();
                k--;
            }
            stack.addLast(num);
        }
        
        while (k-- > 0) {
            stack.removeLast();
        }
        
        for (char num : stack) {
            answer.append(num);
        }
        
        return answer.toString();
    }
}