import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static String a, b;

  public static void main(String [] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = st.nextToken();
    b = st.nextToken();

    String reversedA = new StringBuilder(a).reverse().toString();
    String reversedB = new StringBuilder(b).reverse().toString();

    int numA = Integer.parseInt(reversedA);
    int numB = Integer.parseInt(reversedB);

    int max = Math.max(numA, numB);
    System.out.print(max);
  }
}