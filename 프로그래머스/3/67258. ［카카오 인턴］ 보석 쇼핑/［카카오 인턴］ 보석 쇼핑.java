import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        
        int len = set.size(); // 보석 종류
        int left = 0, right = 0; // 슬라이딩 윈도우
        int min = Integer.MAX_VALUE;
        
        Map<String, Integer> count = new HashMap<>();
        while(right < gems.length) {
            count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);
            right++;
            
            // 축소
            while (count.size() == len && left < right) {
                if (right - left < min) {
                    min = right - left;
                    answer[0] = left + 1; // 1번부터 시작하는 번호로 변환
                    answer[1] = right;
                }
                
                count.put(gems[left], count.get(gems[left]) - 1);
                
                if (count.get(gems[left]) == 0) {
                    count.remove(gems[left]);
                }

                left++;
            }
        }
        return answer;
    }
}