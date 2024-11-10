import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<int[]> deque = new ArrayDeque<int[]>();

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.addLast(new int[] {i + 1, Integer.parseInt(st.nextToken())});
        }

        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            int[] current = deque.removeFirst();
            int index = current[0];
            int move = current[1];
            
            sb.append(index).append(" ");
            
            if (deque.isEmpty()) break;
            
            if (move > 0) { 
               
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}