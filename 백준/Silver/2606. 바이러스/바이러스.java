import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static int[][] adj; // 2차원 인접행렬
    static boolean[] visited;
    static int startNode = 1;
    static ArrayList<Integer> track = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        E = Integer.parseInt(br.readLine()); // 간선
        adj = new int[V + 1][V + 1];
        visited = new boolean[V + 1];

        // 인접행렬
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start][end] = 1;
            adj[end][start] = 1;
        }

        ArrayDeque<Integer> Queue = new ArrayDeque<>(Arrays.asList(startNode));
        while (!Queue.isEmpty()) {
            int current = Queue.removeFirst();
            if (!visited[current]) {
                visited[current] = true;
                track.add(current);
            }

            for (int destination = 1; destination < V + 1; destination++) {
                // 도착 노드가 방문체크되지 않았고 + 갈 수 있다면?
                if (!visited[destination] && adj[current][destination] == 1) {
                    Queue.addLast(destination); // 큐에 목적지를 넣어라!

                }
            }
        }
        System.out.println(track.size() - 1);
    }
}