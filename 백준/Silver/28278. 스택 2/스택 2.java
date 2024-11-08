import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> stack = new ArrayDeque<Integer>();

    static Integer order(int[] cmd){
        switch (cmd[0]) {
            case 1:
                stack.addLast(cmd[1]);
                break;
            case 2:
                return stack.isEmpty() ? -1 : stack.removeLast();
            case 3:
                return stack.size();
            case 4:
                return stack.isEmpty() ? 1 : 0;
            default:
                return stack.isEmpty() ? -1 : stack.getLast();
        }

        return null;
    }

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int[] cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Integer answer = order(cmd);
            if(answer != null){
                System.out.println(answer);
            }
        }
    }
}