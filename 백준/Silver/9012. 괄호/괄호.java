import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static String list;

    public String solution(String vps) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < vps.length(); i++){
            char ch = vps.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else if(ch == ')'){
                if (stack.empty()) return "NO";
                stack.pop();
            }
        }
        
        return stack.empty() ? "YES" : "NO";
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++){
            list = br.readLine();
            String answer = T.solution(list);
            System.out.println(answer);
        }
    }
}