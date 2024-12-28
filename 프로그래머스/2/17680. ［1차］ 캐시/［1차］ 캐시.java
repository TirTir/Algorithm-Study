import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        ArrayList<String> cache = new ArrayList<>();
        for(String c : cities) {
            
            if (cacheSize == 0) {
                return cities.length * 5;
            }
            
            c = c.toLowerCase();
            
            if(cache.contains(c)) {
                // cache hit
                cache.remove(c);
                cache.add(0, c);
                answer += 1;
            } else {
                // cache miss
                if (cache.size() == cacheSize) {
                    cache.remove(cacheSize - 1);
                }
                cache.add(0, c);
                answer += 5;
            }
        }
        
        return answer;
    }
}