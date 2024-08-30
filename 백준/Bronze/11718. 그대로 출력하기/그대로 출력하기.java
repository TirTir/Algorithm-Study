import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static ArrayList<String> list = new ArrayList<>();

  public static void main(String [] args) throws IOException{
    String input = "";

    while((input = br.readLine()) != null && !input.isEmpty()) {
      list.add(input);
    }

    for (String text : list) {
      System.out.println(text);
    }

  }
}