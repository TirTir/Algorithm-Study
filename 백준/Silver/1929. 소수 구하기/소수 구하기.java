import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] num = new int[n + 1];

		StringBuffer sb = new StringBuffer();
		for (int i = 2; i * i <= n; i++) {
			if (num[i] == 0) {
					for (int j = i * i; j <= n; j += i) {
							num[j] = 1;
					}
			}
	}

		for (int i = Math.max(m, 2); i <= n; i++) {
			if (num[i] == 0) sb.append(i).append("\n");
		}

		System.out.println(sb.toString());
	}
}