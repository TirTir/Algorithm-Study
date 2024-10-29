import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 100000;
    static boolean[] visited = new boolean[MAX + 1];

    static class d {
        int a, b, c;
        d (int x) {
            this.a = x + 1;
            this.b = x - 1;
            this.c = x * 2;
        }

        int[] getValues() {
            return new int[]{a, b, c};
        }
    }

    static int bfs(int n, int k){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{n, 0}); // 거리, 시간
        visited[n] = true;

        while(!queue.isEmpty()){
            int[] x = queue.removeFirst();

            if(x[0] == k){
                return x[1];
            }

            d dx = new d(x[0]);
            for(int next : dx.getValues()) {
                if(next >= 0 && next <= MAX && !visited[next]){
                    visited[next] = true;
                    queue.addLast(new int[] {next, x[1]+1});
                }
            }
        }

        return -1;
    }

    public static void main(String [] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = bfs(n, k);
        System.out.println(answer);
    }
}