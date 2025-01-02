import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        
        int[] dp_l = new int[n];
        int[] dp_r = new int[n];
        
        for(int i = 0; i < n - 1; i++) {
            left.add(topping[i]);
            right.add(topping[n - (i+1)]);
            
            dp_l[i] = left.size();
            dp_r[n - (i+1)] = right.size();
        }
        
        for(int i = 0; i < n-1; i++) {
            if(dp_l[i] == dp_r[i+1]) answer++;
        }
        
        return answer;
    }
    
    
}