import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // ArrayList<String> list = new ArrayList<>(); -> 시간 초과
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> answer = new ArrayList<>();
    for(int i = 0; i < n; i++){
      map.put(br.readLine(), 1);
    }

    for(int i = 0; i < m; i++){
      String str = br.readLine();
      if(map.get(str) != null) answer.add(str);
    }

    Collections.sort(answer);

    StringBuffer sb = new StringBuffer();
    sb.append(answer.size()).append("\n");

    for(int i = 0; i < answer.size(); i++){
      sb.append(answer.get(i)).append("\n");
    }

    System.out.println(sb.toString());
	}
};