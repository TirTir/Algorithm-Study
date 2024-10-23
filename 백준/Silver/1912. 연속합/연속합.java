import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr, dp;

    public int solution(int n){
        dp[0] = arr[0];
        int answer = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n+1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        System.out.println(T.solution(n));
    }
}