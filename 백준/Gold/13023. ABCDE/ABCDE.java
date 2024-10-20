import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public void dfs(int start, int depth){
        if (depth == 5) {
            found = true;
            return;
        }

        visited[start] = true; // 시작 노드 방문 처리

        // DFS 탐색
        for (int node : graph[start]) {
            if (!visited[node]) {
                dfs(node, depth+1);
            }
        }

        visited[start] = false; // 백트래킹
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new ArrayList[n];
        visited = new boolean[n]; // 초기화

        // 연결 리스트 초기화
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n; i++){
            if(found) break;
            T.dfs(i, 1);
        }

        System.out.println(found ? 1 : 0);
    }
}