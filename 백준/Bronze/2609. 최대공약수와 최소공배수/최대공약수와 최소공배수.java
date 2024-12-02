import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String [] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] cl = new int[]{n, m};

    while (m != 0) {
      int temp = n % m;
      n = m;
      m = temp;
    }

    System.out.println(n);
    System.out.println((cl[0] * cl[1]) / n);
  }
};