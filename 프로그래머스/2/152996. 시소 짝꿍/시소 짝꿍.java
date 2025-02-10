import java.util.*;

class Solution {
    static int[][] dx = {{2, 3}, {3, 4}, {1, 2}};
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int weight : weights) {
            if (map.containsKey(weight)) {
                answer += map.get(weight);
            }
        
            for (int[] x : dx) {
                // 비율
                int a = weight * x[0];
                int b = x[1];

                // 나누어 떨어지는 경우만 확인
                if (a % b == 0) {
                    int targetWeight = a / b;
                    if (map.containsKey(targetWeight)) {
                        answer += map.get(targetWeight);
                    }
                }

            }
        
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
                    
        return answer;
    }
}