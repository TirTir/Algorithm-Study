import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int index = 27;
        
        // 사전 초기화
        Map<String, Integer> map = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char) i), i - 'A' + 1);
        }
        
        String str = "";
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < msg.length(); i++) {
            str += msg.charAt(i);
            
            if (i == msg.length() - 1 || !map.containsKey(str + msg.charAt(i + 1))) {
                answer.add(map.get(str));
                if (i < msg.length() - 1) {
                    map.put(str + msg.charAt(i + 1), index++); // 새로운 문자열 추가
                }
                str = ""; // 초기화
            }
            
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}