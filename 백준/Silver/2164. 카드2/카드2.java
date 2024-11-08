import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1; i <= n; i++){
            queue.addLast(i);
        }

        while(!queue.isEmpty()){
            if(queue.size() == 1){
                answer = queue.removeLast();
                break;
            }

            queue.removeFirst();
            int next = queue.removeFirst();
            queue.addLast(next);
        }

        System.out.println(answer);
    }
}