import java.util.*;

class Solution {
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    static boolean found = false;
    static int answer = 0;
    
    public int solution(String word) {
        dfs("", word, 0);
        return answer;
    }
    
    static void dfs(String str, String word, int depth) {
        if (str.equals(word)) {
            found = true;
            return;
        }
        
        if (depth == 5 || found) return;
        
        for(int i = 0; i < 5; i++) {
            answer++;
            dfs(str + ch[i], word, depth + 1);
            if(found) return;
        }
    }
}