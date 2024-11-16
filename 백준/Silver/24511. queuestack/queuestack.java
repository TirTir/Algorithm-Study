import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

				int[] arr = new int[n];
				Deque<Integer> deque = new ArrayDeque<>();

				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 0; i < n; i++){
					arr[i] = Integer.parseInt(st.nextToken());
				}

				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < n; i++){
					int num = Integer.parseInt(st.nextToken());
					if(arr[i] == 0){
							deque.addLast(num);
					}
				}

        int m = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				
				StringBuffer sb = new StringBuffer();

				while(m --> 0){
            int moveValue = Integer.parseInt(st.nextToken());
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" ");
        }

				System.out.println(sb.toString());
    }
}