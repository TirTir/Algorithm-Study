import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int h = 1; h <= Math.sqrt(yellow); h++) {
            if(yellow % h != 0) continue;
            
            int w = yellow / h;
            int sum = 2 * (w + h) + 4;
            
            if(sum == brown) {
                answer = (w + 2 >= h + 2) ? new int[] {w + 2, h + 2} : new int[] {h + 2, w + 2};
                break;
            }
        }
        
        return answer;
    }
}