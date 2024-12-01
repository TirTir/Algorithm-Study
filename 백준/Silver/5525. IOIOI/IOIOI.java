import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine()); // 길이
    String s = br.readLine();

    StringBuilder sb = new StringBuilder("I");
    for (int i = 0; i < n; i++) {
      sb.append("OI");
    }

    String str = sb.toString();
    int answer = 0;

    for(int i = 0; i <= m - str.length(); i++){     
      if(s.substring(i, i + str.length()).equals(str)){
        answer++;
      }
    }

    System.out.println(answer);
  }
};