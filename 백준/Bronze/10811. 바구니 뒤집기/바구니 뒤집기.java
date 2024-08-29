import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int n, m;
   static List<Integer>[] nums;
   static List<Integer> answer;

  public static void main(String [] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new ArrayList[m];
    answer = new ArrayList<>();

    for(int i = 0; i < m; i++){
      nums[i] = Arrays.stream(br.readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .boxed()
      .collect(Collectors.toList());
    }

    for(int i = 0; i < n; i++){
      answer.add(i+1);
    }

    for(int i = 0; i < m; i++){
      int startIndex = nums[i].get(0)-1;
      int endIndex = nums[i].get(1);
      List<Integer> subList = answer.subList(startIndex, endIndex);
      Collections.reverse(subList); //역순
    }

    for(int i = 0; i < n; i++){
      if (i > 0) {
        System.out.print(" ");
      }
      System.out.print(answer.get(i));
    }
  }
}
