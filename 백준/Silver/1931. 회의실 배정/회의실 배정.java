import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> list = new ArrayList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int answer;

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }

        // 끝나는 시간 기준 정렬
        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int lastEndTime = 0;
        for (int[] time : list) {
            if(time[0] >= lastEndTime){
                lastEndTime = time[1]; // 회의 끝나는 시간 갱신
                answer++;
            }
        }

        System.out.println(answer);
    }
}