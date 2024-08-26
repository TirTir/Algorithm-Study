import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums = new int[10];
    static Set<Integer> answer = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        for(int i  = 0; i < 10; i++){
            nums[i] = Integer.parseInt(br.readLine());
            answer.add(nums[i] % 42);
        }
        System.out.print(answer.size());
    }
}
