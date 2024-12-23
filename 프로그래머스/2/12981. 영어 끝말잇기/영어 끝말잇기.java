import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(0);
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if(word.length() < 2 || set.contains(word) || word.charAt(0) != lastChar) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            

            set.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return answer;
    }
}