import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Double> stack = new ArrayDeque<>();
    static HashMap<Character, Double> map = new HashMap<>();

    public Double solution(String arr){
        for(int i = 0; i < arr.length(); i++){
            char ch = arr.charAt(i);

            if (ch >= 'A' && ch <= 'Z'){
                stack.addLast(map.get(ch));
            } else {
                double result = 0;
                double b = stack.removeLast();
                double a = stack.removeLast();
                
                switch (ch) {
                    case '*':
                        result = a * b;
                        break;
                    case '+':
                        result = a + b;
                        break; 
                    case '-':
                        result = a - b;
                        break;
                    default:
                        result = a / b;
                        break;
                }
                stack.addLast(result);
            }
        }

        return stack.peekLast();
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }

        System.out.println(String.format("%.2f", T.solution(input)));
    }
}