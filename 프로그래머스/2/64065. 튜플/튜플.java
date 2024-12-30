import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] elements = s.replaceAll("[{}]", "").split(",");
        
        Map<Integer, Integer> map = new HashMap<>();
        for (String element : elements) {
            int num = Integer.parseInt(element);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }
        
        return answer;
    }
}