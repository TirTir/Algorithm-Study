import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
    int n = Integer.parseInt(br.readLine()); // N개
    int m = Integer.parseInt(br.readLine()); // 길이
    String s = br.readLine();

    int cnt = 0, answer = 0;
    for(int i = 1; i < m-1;){
      if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I'){
        cnt++;
        if(cnt == n){
          if(s.charAt(i - (n*2 - 1)) == 'I'){
            answer++;
          }
          cnt--;
        }
        i += 2; // O 부터 비교
      } else {
        cnt = 0;
        i++;
      }
    }

    System.out.println(answer);
  }
};