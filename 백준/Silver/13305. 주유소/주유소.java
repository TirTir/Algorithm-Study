import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws IOException{
			int n = Integer.parseInt(br.readLine());
			long[] price = new long[n];
			int answer = 0;
			
			long[] len = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++){
				price[i] = Integer.parseInt(st.nextToken());
			}

			long minPrice = price[0];
			for(int i = 0; i < len.length; i++){
				if (price[i] < minPrice) {
					minPrice = price[i];
				}
				answer += minPrice * len[i];
			}
			System.out.println(answer);
		}
}