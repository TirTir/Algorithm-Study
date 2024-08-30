import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int T;
   static String text;
   static String[] answer;

  public static void main(String [] args) throws IOException{
    T = Integer.parseInt(br.readLine());
    answer = new String[T];

    for(int i = 0; i < T; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      String text = st.nextToken();

      String word = "";

      for(int j = 0; j < text.length(); j++){
        for(int k = 0; k < n; k++)
          word += text.charAt(j);
      }

      answer[i] = word;
    }

    for(int i = 0; i < T; i++){
      System.out.println(answer[i]);
    }
  }
}