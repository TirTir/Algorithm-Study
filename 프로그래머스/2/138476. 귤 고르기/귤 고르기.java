import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            if(count >= k) {
                break;
            }
            count += entry.getValue();
            answer++;
        }
        
        return answer;
    }
}