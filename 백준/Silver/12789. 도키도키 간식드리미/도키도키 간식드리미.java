import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> line = new ArrayDeque<Integer>();
    static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int a : arr){
            line.addLast(a);
        }

        int expected = 1;

        while (!line.isEmpty()) {
            if (line.getFirst() == expected) { 
                line.removeFirst();
                expected++;
            } else if (!stack.isEmpty() && stack.getLast() == expected) {
                stack.removeLast();
                expected++;
            } else {
                stack.addLast(line.removeFirst());
            }
        }

        while (!stack.isEmpty() && stack.getLast() == expected) {
            stack.removeLast();
            expected++;
        }


        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}