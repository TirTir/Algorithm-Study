import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<String> queue = new ArrayDeque<String>();

    static String order(String[] input){
        switch (input[0]) {
            case "push":
                queue.addLast(input[1]);
                break;
            case "pop":
                if (!queue.isEmpty()) {
                    return queue.removeFirst();
                }
                return "-1";
            case "size":
                return Integer.toString(queue.size());
            case "empty":
                return queue.isEmpty() ? "1" : "0";
            case "front":
                return queue.isEmpty() ? "-1" : queue.getFirst();
            default:
                return queue.isEmpty() ? "-1" : queue.getLast();
        }

        return null;
    }
    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            String input[] = br.readLine().split(" ");
            String answer = order(input);
            if(answer != null){
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
    }
}