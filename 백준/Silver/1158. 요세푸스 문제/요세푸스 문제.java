import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) queue.offer(i);

        sb.append("<");

        while(!queue.isEmpty()){
            for(int i = 0; i < k - 1; i++){
                int num = queue.poll();
                queue.offer(num);
            }

            sb.append(queue.poll());

            if (!queue.isEmpty()) {
                sb.append(", ");
            }

        }

        sb.append(">");
        System.out.println(sb.toString());
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();

        int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        int n = input[0];
        int k = input[1];

        T.solution(n, k);
    }
}