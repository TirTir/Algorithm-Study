import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String [] args) throws IOException{
        List<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            queue.addLast(i);
        }

        while(!queue.isEmpty()){
            for(int i = 1; i < k; i++){
                int num = queue.removeFirst();
                queue.addLast(num);
            }
            answer.add(queue.removeFirst());
        }

        StringBuffer sb = new StringBuffer("<");
        for(int i = 0; i < answer.size() - 1; i++){
            sb.append(answer.get(i)).append(", ");
        }
        
        sb.append(answer.get(answer.size() - 1)).append(">");
        System.out.println(sb.toString());
    }
}