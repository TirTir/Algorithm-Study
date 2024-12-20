import java.util.*;

class Solution {
    public int solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == ch) {
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}