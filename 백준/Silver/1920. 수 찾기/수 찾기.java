import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;

	static boolean binarySearch(int target){
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			// 1. 배열의 중간값
			int mid = left + (right - left) / 2;

			if(arr[mid] == target) return true;
			else if(arr[mid] < target) left = mid + 1;
			else right = mid - 1;
		}

		return false;
	}

	public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < m; i++){
			if(binarySearch(Integer.parseInt(st.nextToken()))){
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}