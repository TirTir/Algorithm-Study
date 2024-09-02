import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> answer = new ArrayList<>();
        int idx = 0;
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                answer.add(str);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}