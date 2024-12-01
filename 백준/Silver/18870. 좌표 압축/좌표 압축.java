import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String [] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
    int[] cl = arr.clone();
    Arrays.sort(cl);

    HashMap<Integer, Integer> map = new HashMap<>();
    int rank = 0;

    // 순위 매기기
    for(int a : cl){
      if(!map.containsKey(a)){
        map.put(a, rank);
        rank++;
      }
    }

    StringBuffer sb = new StringBuffer();
    for(int a : arr){
      sb.append(map.get(a)).append(" ");
    }

    System.out.println(sb.toString());
  }
};