import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static String s;
   static int index;

  public static void main(String [] args) throws IOException{
    s = br.readLine();
    index = Integer.parseInt(br.readLine());

    System.out.print(s.charAt(index-1));
  }
}
