import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();

        if (!list.contains(2)) return new int[]{-1};
        else {
          int startIndex = list.indexOf(2);
          int endIndex = list.lastIndexOf(2);

          answer = list.subList(startIndex, endIndex + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}