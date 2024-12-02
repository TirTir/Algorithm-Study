import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
    int t = Integer.parseInt(br.readLine());

    // R 뒤집기 D 버리기
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < t; i++){
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine()); // 수 개수
      String input = br.readLine();

      int[] arr;
      if (input.equals("[]")) {
        arr = new int[0]; // 빈 배열
      } else{
        arr = Arrays.stream(input.replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();
      }

      boolean flag = false; // 에러 여부
      boolean reversed = false; // 뒤집기 여부
      Deque<Integer> deque = new ArrayDeque<>();
      for(int a : arr){
        deque.add(a);
      }

      for(int j = 0; j < p.length(); j++){
        char ch = p.charAt(j);

        if(ch == 'R'){
          reversed = !reversed;
          continue;
        }

        if(deque.isEmpty()) {
          flag = true;
          break;
        }

        if (reversed) {
          deque.removeLast();
        } else {
            deque.removeFirst();
        }
        }

      if(flag){
        sb.append("error").append("\n");
      } else {
        sb.append("[");
        while (!deque.isEmpty()) {
          sb.append(reversed ? deque.removeLast() : deque.removeFirst());
          if (!deque.isEmpty()) {
            sb.append(",");
          }
        }
        sb.append("]").append("\n");
      }
    }

    System.out.println(sb.toString());
  }
};