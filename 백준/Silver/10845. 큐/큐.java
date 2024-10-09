import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> queue = new LinkedList<>();

    public Integer solution(String str) {
        switch(str){
            case "front":
                return queue.isEmpty() ? -1 : queue.peek();
            case "back":
                return queue.isEmpty() ? -1 : queue.toArray(new Integer[0])[queue.size() - 1];
            case "pop":
                return queue.isEmpty() ? -1 : queue.poll();
            case "size":
                return queue.size();
            case "empty":
                return queue.isEmpty() ? 1 : 0;
            default:
                String[] push = str.split(" ");
                queue.offer(Integer.parseInt(push[1]));
                return null;
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            Integer answer = T.solution(br.readLine());
            if (answer != null) {
                System.out.println(answer);
            }
        }
    }
}