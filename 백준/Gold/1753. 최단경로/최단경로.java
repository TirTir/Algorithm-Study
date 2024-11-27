import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
  static boolean[] visited;
  static int[] dist;

  static class Node {
    int v, w;

    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  static void dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node o1, Node o2){
        return o1.w - o2.w;
      }
    });

    dist[start] = 0; // 출발점에 대한 최단 경로
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()){
      Node cur = pq.poll();

      if(cur.w > dist[cur.v]) continue;

      for(int i = 0; i < graph.get(cur.v).size(); i++){
        Node next = graph.get(cur.v).get(i);

        if(dist[next.v] > dist[cur.v] + next.w){
          dist[next.v] = dist[cur.v] + next.w;
          pq.add(new Node(next.v, dist[next.v]));
        }
      }

    }
  }

  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());

    visited = new boolean[v]; // 방문 여부
    dist = new int[v]; // 최소 거리 저장

    for(int i = 0; i < v; i++){
      graph.add(new ArrayList<>()); // 그래프 초기화
      dist[i] = Integer.MAX_VALUE; // 최소 비용 최대 지정
    }

    for(int i = 0; i < e; i++){
      st = new StringTokenizer(br.readLine());
      int a1 = Integer.parseInt(st.nextToken());
      int a2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      
      graph.get(a1-1).add(new Node(a2-1, w));
    }

    dijkstra(k-1);

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < v; i++){
      if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
      else sb.append(dist[i]).append("\n");
    }

    System.out.println(sb.toString());
	}
};