import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Integer> nums = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {

        for(int i  = 0; i < 28; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < 30; i++){
            if (!nums.contains(i+1)){
                System.out.println(i+1);
            }
        }
    }
}
