import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static class Number implements Comparable<Number> {
		int num, index;

		Number(int num, int index) {
				this.num = num;
				this.index = index;
		}

		@Override
		public int compareTo(Number o) {
				return num - o.num;
		}
}

	public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		Number[] arr = new Number[n+1];

		for(int i = 1; i <= n; i++){
			arr[i] = new Number(Integer.parseInt(br.readLine()), i);
		}

		Arrays.sort(arr, 1, n+1);
		
		int answer = 0;
		for(int i = 1; i <= n; i++){
			answer = Math.max(answer, arr[i].index - i);
		}

		System.out.print(answer + 1);
	}
}
