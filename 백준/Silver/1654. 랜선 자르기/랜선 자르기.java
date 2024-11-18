import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int k, n;
	static long[] arr;

	public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken()); // target

		arr = new long[k];
        long answer = 0;

		for(int i = 0; i < k; i++){ // 랜선 길이
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        Arrays.sort(arr);

		long left = 1;
		long right = arr[k-1];
		
		while (left <= right) {
			long mid = left + (right - left) / 2;

			long count = 0;
			for(long len : arr) {
				count += len / mid;
				if (count > n) break;
			}

			if(count >= n){
                answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}