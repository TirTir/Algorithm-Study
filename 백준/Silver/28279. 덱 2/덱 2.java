import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deque = new ArrayDeque<Integer>();

    static Integer order(String[] cmd){
        switch (cmd[0]) {
            case "1":
                deque.addFirst(Integer.parseInt(cmd[1]));
                break;
            case "2":
                deque.addLast(Integer.parseInt(cmd[1]));
                break;
            case "3":
                return deque.isEmpty() ? -1 : deque.removeFirst();
            case "4":
                return deque.isEmpty() ? -1 : deque.removeLast();
            case "5":
                return deque.size();
            case "6":
                return deque.isEmpty() ? 1 : 0;
            case "7":
                return deque.isEmpty() ? -1 : deque.getFirst();
            case "8":
                return deque.isEmpty() ? -1 : deque.getLast();
        }
        return null;
    }

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Integer answer;

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            answer = order(input);

            if(answer != null){
                System.out.println(answer);
            }
        }
    }
}