import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
  static int INF = 200000000;
  static int n, e;

  static class Node {
    int v, w;

    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  static int[] dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node o1, Node o2){
        return o1.w - o2.w;
      }
    });

    int[] dist  = new int[n];
    Arrays.fill(dist, INF);

    dist[start] = 0; // 출발점에 대한 최단 경로
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()){
      Node cur = pq.poll();

      if(cur.w > dist[cur.v]) continue;

      for (Node next : graph.get(cur.v)) {

        if(dist[next.v] > dist[cur.v] + next.w){
          dist[next.v] = dist[cur.v] + next.w;
          pq.add(new Node(next.v, dist[next.v]));
        }
      }
    }

    return dist;
  }

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // 정점 개수
    e = Integer.parseInt(st.nextToken()); // 간선 개수

    for(int i = 0; i < n; i++){
      graph.add(new ArrayList<>());
    }
    
    for(int i = 0; i < e; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      // 양방향 그래프
      graph.get(a-1).add(new Node(b-1, c));
      graph.get(b-1).add(new Node(a-1, c));
    }

    st = new StringTokenizer(br.readLine());
    int u = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    int[] dist = dijkstra(0);
    int[] u_dist = dijkstra(u-1);
    int[] v_dist = dijkstra(v-1);

    long route1 = dist[u-1] + u_dist[v-1] + v_dist[n-1];
    long route2 = dist[v-1] + v_dist[u-1] + u_dist[n-1];

    long answer = Math.min(route2, route1);
    System.out.println(answer >= INF ? -1 : answer);
	}
};