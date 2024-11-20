import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String [] args) throws IOException{
		// 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지
		int answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++){
			int num = Integer.parseInt(st.nextToken());
			answer += Math.pow(num, 2);
		}

		System.out.println(answer % 10);
	}
}