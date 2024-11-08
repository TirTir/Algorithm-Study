import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String [] args) throws IOException{
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<Character>();
            Boolean answer = true;

            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                if(ch == '('){
                    stack.addLast(ch);
                } else if (ch == ')'){
                    char eq = ' ';
                    if(!stack.isEmpty()) eq = stack.removeLast();
                    if(eq != '(') answer = false;
                }

                if(ch == '['){
                    stack.addLast(ch);
                } else if (ch == ']'){
                    char eq = ' ';
                    if(!stack.isEmpty()) eq = stack.removeLast();
                    if(eq != '[') answer = false;
                }

                if(ch == '.') {
                    if(answer && stack.isEmpty()) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }

        }
    }
}