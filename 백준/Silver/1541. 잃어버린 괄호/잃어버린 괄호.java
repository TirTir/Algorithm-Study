import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static Deque<String> stack = new ArrayDeque<>();

    public static void main(String [] args) throws IOException{
			String str = br.readLine();
			StringBuffer sb = new StringBuffer();

			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				if (ch != '-' && ch != '+') {
                sb.append(ch);
        } else { // 숫자인 경우
					stack.addLast(sb.toString());
					sb.delete(0, sb.length()); // 초기화
					
					stack.addLast(String.valueOf(ch));
				}
			}

			if (sb.length() > 0) {
				stack.addLast(sb.toString());
			}

			int answer = 0;
			boolean sub = false;

			while(!stack.isEmpty()){
				String current = stack.removeFirst();

				if (current.equals("-")) {
					sub = true;
				} else if (current.equals("+")) {
					continue;
        } else {
          int num = Integer.parseInt(current);
					if(sub) answer -= num;
					else answer += num;
				}
			}

			System.out.println(answer);
    }
}