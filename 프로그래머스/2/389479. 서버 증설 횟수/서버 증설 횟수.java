import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        for(int i = 0; i < 24; i++) {
        
            if(players[i] > 0) { 
                int count = 0;
                
                for(int j = 0; j < k; j++) {
                    if(i-j < 0) break;
                    else count += server[i-j];
                
                }
                
                if((count + 1) * m <= players[i]) {
                    server[i] += (players[i] - (count * m)) / m;
                    answer += server[i];
                }
            
            }
        }
        
        return answer;
    }
}