import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList();

        for(int i = 0; i < flag.length; i++){
            if(flag[i]) {
                answer.addAll(Collections.nCopies(arr[i] * 2, arr[i]));
            }
            else {
                answer.subList(answer.size() - arr[i], answer.size()).clear();
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}