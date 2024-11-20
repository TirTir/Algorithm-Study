import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int solution(String str){
		int answer = 0, count = 1;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == 'X'){
				count = 1;
			} else {
				answer += count++;
			}
		}

		return answer;
	}
	public static void main(String [] args) throws IOException{
		int t = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < t; i++){
			sb.append(solution(br.readLine())).append("\n");
		}
		System.out.println(sb.toString());
	}
}