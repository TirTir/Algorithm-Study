import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int gcd(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
  }

  static int lcm(int a, int b) {
      return a / gcd(a, b) * b;
  }
  public static void main(String [] args) throws IOException{
    int t = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    for(int i = 0; i < t; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      boolean flag = true;

      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for(int year = x; year <= lcm(m, n); year += m){
        if (year % n == (y == n ? 0 : y)){
          sb.append(year).append("\n");
          flag = false;
          break;
        }
      }
      if(flag) sb.append(-1).append("\n");
    }

    System.out.println(sb.toString());
  }
};