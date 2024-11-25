import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++){
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}