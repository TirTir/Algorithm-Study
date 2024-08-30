import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int t;
   static String[] str;
   static String[] answer;

  public static void main(String [] args) throws IOException{
    t = Integer.parseInt(br.readLine());
    str = new String[t];
    answer = new String[t];

    for(int i = 0; i < t; i++){
      str[i] = br.readLine();
      int len = str[i].length();
      answer[i] = str[i].charAt(0) + "" + str[i].charAt(len - 1);
    }

    for(int i = 0; i < t; i++){
      System.out.println(answer[i]);
    }
  }
}
