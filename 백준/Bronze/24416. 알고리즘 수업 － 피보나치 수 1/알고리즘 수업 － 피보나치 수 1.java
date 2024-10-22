import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int fibCount = 0;

    public int fib(int n){
        if(n <= 2){
            fibCount++;
            return 1;
        } else {
            return fib(n - 1) + fib(n-2);
        }
    }

    public int fibonacci(int n){
        int fibonacciCount = 0;
        int[] f = new int[n+1];
        f[1] = f[2] = 1;

        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
            fibonacciCount++;
        }

        return fibonacciCount;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        
        StringBuffer sb = new StringBuffer();
        sb.append(T.fib(n)).append(" ").append(T.fibonacci(n));

        System.out.println(sb);
    }
}