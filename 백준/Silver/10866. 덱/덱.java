import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deque = new ArrayDeque<>();

    public Integer solution(String str) {
        switch(str){
            case "front":
                return deque.peek();
            case "back":
                return deque.peekLast();
            case "pop_front":
                return deque.poll();
            case "pop_back":
                return deque.pollLast();
            case "size":
                return deque.size();
            case "empty":
                return deque.isEmpty() ? 1 : 0;
            default: 
                String[] push = str.split(" ");
                if (push[0].equals("push_front")) {
                    deque.offerFirst(Integer.parseInt(push[1]));
                } else if (push[0].equals("push_back")) {
                    deque.offerLast(Integer.parseInt(push[1]));
                }
                return -2;
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            Integer answer = T.solution(br.readLine());
            if (answer != null) {
                if(answer < 0) continue;
                System.out.println(answer);
            } else {
                System.out.println(-1);
            }
        }
    }
}