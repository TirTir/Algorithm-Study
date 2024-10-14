import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> deque = new ArrayDeque<>(); // Stack

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast() <= arr[i]) {
                deque.removeLast();
            }

            if (!deque.isEmpty()) {
                answer[i] = deque.peekLast();
            } else {
                answer[i] = -1;
            }

            deque.addLast(arr[i]);
        }

        return answer;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = T.solution(n, arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}