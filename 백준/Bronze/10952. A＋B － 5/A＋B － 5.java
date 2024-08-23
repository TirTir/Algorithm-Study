import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }

            if (sum == 0) {
                break;
            }

            nums.add(sum);
        }

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
}