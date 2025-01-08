import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.addLast(s.charAt(i));
            } else if(!stack.isEmpty() && stack.peekLast() == '(') {
                stack.removeLast();
            } else {
                answer = false;
                break;
            }         
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}