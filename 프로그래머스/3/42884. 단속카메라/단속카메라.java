import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        // route[0] : 진입 route[1] : 진출
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int current = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(current < route[0]) {
                current = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}