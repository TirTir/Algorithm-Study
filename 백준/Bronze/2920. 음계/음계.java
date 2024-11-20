import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String solution(int[] arr, int start){
		int flag = 0;
		if(start == 1) {
			flag = 1;
		} else {
			flag = -1;
		}

		for(int i = 0; i < 8; i++){
			if(arr[i] - start == 0){
				start += flag;
			} else {
				return "mixed";
			}
		}
		return flag > 0 ? "ascending" : "descending";
	}
	public static void main(String [] args) throws IOException{
		// ascending인지, descending인지, mixed인지 판별
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		if(arr[0] == 1 || arr[0] == 8){
			System.out.println(solution(arr, arr[0]));
		} else {
			System.out.println("mixed");
		}
	}
}