import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
		int t = Integer.parseInt(br.readLine());

    while(t --> 0){
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> map = new HashMap<>();
      for(int i = 0; i < n; i++){
        // 이름, 종류 -> 같은 종류 의상 하나씩
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String type = st.nextToken();

        // 입지 않는 경우 포함
        map.put(type, map.getOrDefault(type, 0) + 1);
      }

      int answer = 1;
      for(int count : map.values()){
        answer *= (count + 1);
      }
      
      System.out.println(answer - 1);
    }
	}
};