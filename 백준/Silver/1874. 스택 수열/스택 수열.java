import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Deque<Integer> stack = new ArrayDeque<>();

   public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		boolean flag = false;

		//스택에 push하는 순서는 반드시 오름차순
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for(int i = 0; i < n; i++){
			int p = Integer.parseInt(br.readLine());

			while(stack.isEmpty() || stack.peekLast() < p){
				if(p < count) {
					flag = true;
					break;
				}
				stack.addLast(count);
				count++;

				sb.append("+").append("\n");
			}

			while(!stack.isEmpty() && stack.peekLast() >= p){
				stack.removeLast();
				sb.append("-").append("\n");
			}
		}

		System.out.println(flag ? "NO" : sb.toString());
	 }
}