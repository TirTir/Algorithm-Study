import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;

    public void bfs(int v){ 
        Deque<Integer> queue = new ArrayDeque<>(); // Queue 사용
        queue.addLast(v);
        
        visited[v] = true; // 시작 노드 방문 처리

        // BFS 탐색
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();

            for(int node : graph[cur]){
                if(!visited[node]){
                    visited[node] = true;
                    queue.addLast(node);
                }
            }
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new ArrayList[n+1];

        // 연결 리스트 초기화
        for(int i = 0; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){
                T.bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}