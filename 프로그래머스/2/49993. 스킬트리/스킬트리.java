import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 스킬 리스트
        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i < skill.length(); i++) {
            char ch = skill.charAt(i);
            list.add(ch);
        }
        
        for(String tree : skill_trees) {
            // 초기화
            int level = 0;
            ArrayList<Character> learn = new ArrayList<>();
            
            for(int i = 0; i < tree.length(); i++) {
                char ch = tree.charAt(i);
                
                if(!list.contains(ch)) {
                    continue;
                }
                
                if(!learn.contains(ch) && list.get(level) == ch) {
                    learn.add(ch);
                    level ++;
                    continue;
                } 
                
                level = -1;
                break;
            }
            
            if(level != -1) answer++; // 통과
        }
        return answer;
    }
}