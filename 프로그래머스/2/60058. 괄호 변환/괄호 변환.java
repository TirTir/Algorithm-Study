import java.util.*;

class Solution {
    public String solution(String p) {
        
        // 1. 빈 문자열이면 반환
        if (p.isEmpty()) return p; 
        else return dfs(p);
    }
    
    private static String dfs(String str) {
        // StackOverflow 방지
        if (str.length() == 0) return str;
        
        // 2. u, v 분리
        String u = "", v = "";
        int cnt1 = 0, cnt2 = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '(') cnt1++;
            else cnt2++;
            
            
            // 균형잡힌 괄호 문자열
            if (cnt1 == cnt2) {
                u = str.substring(0, i + 1);
                v = str.substring(i + 1);
                break;
            }
        }
        
        if(isCorrect(u)) {
            return u + dfs(v);
        } else {
            // 4. 변환 수행
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(dfs(v));
            sb.append(")");
            
            for (int j = 1; j < u.length() - 1; j++) {
                sb.append(u.charAt(j) == '(' ? ')' : '(');
            }
            
            return sb.toString();
        }
    }
    
    private static boolean isCorrect(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        // 3. 올바른 괄호 문자열
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.addLast(ch);
            } else if(stack.isEmpty()) {
                return false;
            } else {
                stack.removeLast();
            }
        }
        
        if (!stack.isEmpty()) return false;
        else return true;
    }
}