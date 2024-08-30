import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static String text;
   static char[] answer;

  public static void main(String [] args) throws IOException{
    text = br.readLine();
     answer = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    for(int i = 0; i < answer.length; i++){
      if(i > 0) System.out.print(" ");

      int index = text.indexOf(answer[i]);
      if(index > -1) System.out.print(index);
      else System.out.print(-1);
    }
  }
}