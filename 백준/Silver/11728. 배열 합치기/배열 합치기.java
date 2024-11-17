import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int[] A, B;

	public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int i = 0, j = 0;
		StringBuffer sb = new StringBuffer();
		while (i < n && j < m) {
			if (A[i] < B[j]) {
					sb.append(A[i++]).append(" ");
			} else {
					sb.append(B[j++]).append(" ");
			}
		}

		while (i < n) {
			sb.append(A[i++]).append(" ");
		}

		while (j < m) {
				sb.append(B[j++]).append(" ");
		}

		System.out.println(sb.toString());
	}
}