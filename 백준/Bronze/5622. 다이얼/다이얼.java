import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static Map<String, Integer> map = new HashMap<>();
   static int answer = 0;
   static String text;

  public static void main(String [] args) throws IOException{
    text = br.readLine();

    String[] groups = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    for (int i = 0; i < groups.length; i++) {
        int number = i + 3;
        for (char c : groups[i].toCharArray()) {
            map.put(String.valueOf(c), number);
        }
    }

    for (int i = 0; i < text.length(); i++){
      char ch = text.charAt(i);
      answer += map.get(String.valueOf(ch));
    }

    System.out.print(answer);
  }
}