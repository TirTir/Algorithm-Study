import java.util.*;
import java.io.*;

class Solution {    
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            deque.addLast(days);
        }

        while(!deque.isEmpty()) {
            int day = deque.removeFirst();
            int count = 1;
            
            while(!deque.isEmpty() && deque.peekFirst() <= day) {
                deque.removeFirst();
                count ++;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}