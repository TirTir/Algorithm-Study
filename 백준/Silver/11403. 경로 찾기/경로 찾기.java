import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  public static void main(String [] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    int[][] graph = new int[n][n];
    
    for(int i = 0; i < n; i++){
      graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][k] == 1 && graph[k][j] == 1) {
            graph[i][j] = 1;
          }
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        sb.append(graph[i][j]).append(" ");  
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
};
