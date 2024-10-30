import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int n, k;
    static int answer;

    public static void main(String [] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = n - 1;
        while(k > 0){
            if(arr[count] > k){
                count--;
            } else{
                k -= arr[count];
                answer++;
            }
        }

        System.out.println(answer);
    }
}