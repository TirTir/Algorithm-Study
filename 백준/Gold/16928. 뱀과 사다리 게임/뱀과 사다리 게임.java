import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 100;
    static int arr[] = new int[MAX + 1];
    static int visited[] = new int[MAX + 1];
    static int n, m;

    static int bfs(){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 1;

        while(!queue.isEmpty()){
            int cur = queue.removeFirst();

            if(cur == MAX){
                return visited[cur] - 1;
            }

            for(int i = 1; i <= 6; i++){
                int dx = cur + i;

                if(dx > MAX || dx < 0){
                    continue;
                }

                if(visited[dx] != 0){
                    continue;
                }

                if(arr[dx] != 0){ // 뱀 or 사다리
                    if (visited[arr[dx]] == 0) {
                        queue.addLast(arr[dx]);
                        visited[arr[dx]] = visited[cur] + 1;
                    }
                } else {
                    queue.addLast(dx);
                    visited[dx] = visited[cur] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String [] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = (Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
    }
}