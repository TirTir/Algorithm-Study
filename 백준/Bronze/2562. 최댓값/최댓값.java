import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums = new int[9];

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 9; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        int max = Arrays.stream(nums)
        .max()
        .getAsInt();

        int maxIndex = IntStream.range(0, nums.length)
            .filter(i -> nums[i] == max)
            .findFirst()
            .orElse(-1);

        System.out.println(max);
        System.out.print(maxIndex + 1);
    }
}