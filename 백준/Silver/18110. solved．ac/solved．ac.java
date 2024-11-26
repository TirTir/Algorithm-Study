import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final double AVG = 0.15;
  public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int num = (int) Math.round(n * AVG);

		int stage = 0;
		int size = n - (num * 2);
		for (int i = num; i < size + num; i++) {
			stage += arr[i];
		}

		System.out.println((int) Math.round((double) stage / size));
	}
};