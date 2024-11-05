import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node>[] tree;
    static int[] visited;
    static int v, answer;

    public static class Node {
        int node, distance;
        
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static int dfs(int n){
        Arrays.fill(visited, -1);
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(new Node(n, 0));
        visited[n] = 0;

        int maxDistance = 0;
        int farthestNode = n;
        
        while(!stack.isEmpty()){
            Node cur = stack.removeLast();

            for(Node next : tree[cur.node]){
                if(visited[next.node] == -1){
                    visited[next.node] = visited[cur.node] + next.distance;
                    stack.add(next);
                } 
                
                if(visited[next.node] > maxDistance){
                    maxDistance = visited[next.node];
                    farthestNode = next.node;
                }
            }
        }

        answer = Math.max(answer, maxDistance);
        return farthestNode;
    }

    public static void main(String [] args) throws IOException{
        v = Integer.parseInt(br.readLine());

        tree = new ArrayList[v + 1];
        visited = new int[v + 1];

        for(int i = 0; i <= v; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            
            while(true) {
                int n = Integer.parseInt(st.nextToken());
                if(n == -1) break;
                int d = Integer.parseInt(st.nextToken());
                tree[index].add(new Node(n, d));
            }
        }

        int farthestNode = dfs(1);
        dfs(farthestNode);

        System.out.println(answer);
    }
}