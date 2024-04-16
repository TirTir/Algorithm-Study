import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { 
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] num;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        //입력 받기

        for (int i = 0; i < n; i++) {
            if(num[i] != 0) minHeap.offer(num[i]);
            else if(minHeap.peek() != null) {
                int answer = minHeap.poll();
                System.out.println(answer);
            } else System.out.println(0);
        }
    }
}