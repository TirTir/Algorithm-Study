import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();

        for(int i : arr){
            if(!nums.contains(i)){
                nums.add(i);
                answer.add(i);
            }

            if(answer.size() == k) break;
        }
        
        while (answer.size() < k) {
            answer.add(-1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}