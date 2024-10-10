import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();

    public Integer solution(String str) {
        int answer = 0;;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if(c =='('){                
                stack.push('(');
            } else{
                stack.pop();

                if(str.charAt(i - 1) == '('){ // 레이저인 경우
                    answer += stack.size();
                } else{ // 쇠막대기 끝
                    answer ++;
                }
            }
        }

        return answer;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        String str = br.readLine();

        int answer = T.solution(str);
        System.out.print(answer);
    }
}