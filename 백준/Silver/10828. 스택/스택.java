import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   Stack<Integer> stack = new Stack<>();
   static String list;
   static int n, answer;

    public Integer solution(String list) {
        switch (list) {
            case "top":
                return stack.empty() ? -1 : stack.peek();
            case "empty":
                return stack.empty() ? 1 : 0;
            case "size":
                return stack.size();
            case "pop":
                return stack.empty() ? -1 : stack.pop();
            default:
                String[] push = new String[2];
                push = list.split(" ");
                stack.push(Integer.parseInt(push[1]));
                return null;
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++){
            list = br.readLine();
            Integer answer = T.solution(list);
            if (answer != null) {
                System.out.println(answer);
            }
        }
    }
}