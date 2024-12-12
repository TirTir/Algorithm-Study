import java.util.*;

class Solution {
    static int n;
    public int[] solution(String[] operations) {
        int[] answer = {};
        n = operations.length;
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        for(int i = 0; i < n; i++){
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            
            if (str[0].equals("I")) {
                min.add(num);
                max.add(num);
            } else if(!min.isEmpty()) {
                int m = 0;
                if(num == 1) m = max.peek();
                else m = min.peek();
                
                max.remove(m);
                min.remove(m);
            }
        }
        
        if(min.isEmpty()) {
            answer = new int[]{0, 0};
        } else if(min.size() == 1) {
            int num = min.peek();
            answer = new int[]{num, num};
        } else {
            answer = new int[]{max.peek(), min.peek()};
        }
        
        return answer;
    }
}