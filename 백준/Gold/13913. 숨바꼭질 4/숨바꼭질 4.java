import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 100000;
    static List<Integer> list = new ArrayList<>();
    static int[][] visited = new int[MAX + 1][2];
    static int n, k;

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

    static int bfs(int n){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(n); // 거리
        visited[n] = new int[]{0, 1};

        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            int time = visited[cur][1];

            if(cur == k){
                return time;
            }

            d dx = new d(cur);
            for(int next : dx.getValues()) {
                if(next >= 0 && next <= MAX && visited[next][1] == 0){
                    visited[next] = new int[]{cur, time + 1};
                    queue.addLast(next);
                }
            }
        }

        return -1;
    }

    public static void main(String [] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int answer = bfs(n);

        StringBuffer sb = new StringBuffer();
        sb.append(answer - 1).append("\n").append(n).append(" ");
        
        while(k != n){
            list.add(k);
            k = visited[k][0]; // 이전 위치
        }

        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
}