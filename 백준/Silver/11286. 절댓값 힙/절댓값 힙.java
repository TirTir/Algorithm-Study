import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String [] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      int a = Math.abs(o1);
      int b = Math.abs(o2);

      if(a == b){ // 절댓값이 같은 경우
        return o1 - o2;
      }

      return a - b;
    });

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < n; i++){
      int x = Integer.parseInt(br.readLine());
      if(x != 0) {
        pq.add(x);
      } else {
        sb.append(pq.isEmpty() ? 0 : pq.remove()).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
};