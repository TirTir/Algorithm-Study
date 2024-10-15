import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (String[] item : clothes) {
            String category = item[1]; 
            
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}