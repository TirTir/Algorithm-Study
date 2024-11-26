import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> name = new HashMap<>();
		HashMap<String, Integer> num = new HashMap<>();
		for(int i = 0; i < n; i++){
			String str = br.readLine();
			name.put(i+1, str);
			num.put(str, i+1);
		}

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < m; i++){
			String str = br.readLine();
			if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
				sb.append(name.get(Integer.parseInt(str))).append("\n");
			} else {
				sb.append(num.get(str)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
};