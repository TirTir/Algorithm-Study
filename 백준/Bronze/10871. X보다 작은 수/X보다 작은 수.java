import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, x;
    static ArrayList<Integer> nums = new ArrayList<>(); // nums 리스트 초기화
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++){
            int num = nums.get(i);
            if(num < x){
                answer.add(num);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(answer.get(i));
        }
    }
}