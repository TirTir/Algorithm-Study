import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] num;

	static boolean binarySearch(int target){
		int left = 0;
		int right = num.length - 1;

		while(left <= right){
			int mid = left + (right - left) / 2;

			if (num[mid] == target) {
				return true;
			} else if (num[mid] < target) {
				left = mid + 1; // 오른쪽 탐색
			} else {
				right = mid - 1; // 왼쪽 탐색
			}
		}

		return false;
	}

	public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < m; i++){
			int target = Integer.parseInt(st.nextToken());

			if (binarySearch(target)) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
