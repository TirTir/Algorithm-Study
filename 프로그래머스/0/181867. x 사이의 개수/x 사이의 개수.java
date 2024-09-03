import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
        int[] answer = Arrays.stream(myString.split("x", -1))
                             .mapToInt(String::length)
                             .toArray();
        
        return answer;
  }
}