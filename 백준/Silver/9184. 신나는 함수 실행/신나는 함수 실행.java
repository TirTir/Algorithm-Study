import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] memo = new int[101][101][101];

    public int w(int a, int b, int c){
        int x = a + 50, y = b + 50, z = c + 50;

        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        } 
        
        if (a > 20 || b > 20 || c > 20){
            return w(20, 20, 20);
        } 
        
        if(memo[x][y][z] != 0) {
            return memo[x][y][z];
        }
        
        
        if (a < b && b < c){
            memo[x][y][z] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            memo[x][y][z] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return memo[x][y][z];
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if(a == -1 && b == -1 && c == -1) break;

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, T.w(a, b, c)));
        }

        System.out.print(sb.toString());
    }
}