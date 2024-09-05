import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = Arrays.stream(arr)
        .flatMap(i -> Arrays.stream(new int[i]).map(n -> i))
        .toArray();
        
        return answer;
    }
}