import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String [] args) throws IOException{
    int t = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    for(int i = 0; i < t; i++){
      int k = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> map = new TreeMap<>();
      
      while (k --> 0) {
        String[] str = br.readLine().split(" ");
        int num = Integer.parseInt(str[1]);

        if(str[0].equals("I")){
          map.put(num, map.getOrDefault(num, 0) + 1);
        } else {
          if (map.isEmpty()) continue; 
          else {
            int n = (num == 1) ? map.lastKey() : map.firstKey();
            if (map.put(n, map.get(n) - 1) == 1) {
              map.remove(n);
            }
          }
        }
      }

      if(map.isEmpty()){
        sb.append("EMPTY").append("\n");
      } else {
        sb.append(map.lastKey()).append(' ').append(map.firstKey()).append("\n");
      }
    }
    
    System.out.println(sb.toString());
  }
};
