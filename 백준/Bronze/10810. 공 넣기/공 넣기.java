import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] nums;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m][3];
        for(int i = 0; i < m; i++){
            nums[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        answer = new int[n];
        Arrays.fill(answer, 0); // 배열의 모든 요소를 0으로 초기화

        for(int i = 0; i < m; i++){
            int k = nums[i][2];
            for(int j = nums[i][0] - 1; j < nums[i][1]; j++){
                answer[j] = k;
            }
        }

        for(int i = 0; i < answer.length; i++){
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(answer[i]);
        }
    }
}
