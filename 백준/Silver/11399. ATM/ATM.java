import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static int[] arr;

    public static void main(String [] args) throws IOException{
			int n = Integer.parseInt(br.readLine());
			int answer = 0;

			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);

			int total = 0;
			for(int i = 0; i < n; i++){
				total += arr[i];
				answer += total;
			}
			
			System.out.println(answer);
    }
}