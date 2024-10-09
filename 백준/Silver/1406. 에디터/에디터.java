import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> leftStack = new Stack<>();
    Stack<Character> rightStack = new Stack<>();


    public void solution(String str) {
        char cmd = str.charAt(0);

        switch(cmd){
            case 'L':
                if(!leftStack.empty()) rightStack.push(leftStack.pop());
                break;
            case 'D':
                if(!rightStack.empty()) leftStack.push(rightStack.pop());
                break;
            case 'B':
                if(!leftStack.empty()) leftStack.pop();
                break;
            case 'P':
                char c = str.charAt(2);
                leftStack.push(c);
                break;
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (char c : str.toCharArray()) {
            T.leftStack.push(c);
        }
        
        for (int i = 0; i < n; i++){
            T.solution(br.readLine());
        }

        StringBuilder answer = new StringBuilder();
        while (!T.leftStack.isEmpty()) {
            T.rightStack.push(T.leftStack.pop());
        }
        while (!T.rightStack.isEmpty()) {
            answer.append(T.rightStack.pop());
        }
        System.out.println(answer.toString());
    }
}