import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] arr;
  static int n, m;

  static long binarySearch(){
    long left = 0;
    long right = arr[n-1];

    long max = 0;

    while(left <= right){
      long mid = left + (right - left) / 2;
      long h = 0;
      
      for (int i = 0; i < n; i++) {
        if (arr[i] > mid) {
            h += (arr[i] - mid);
        }
    }

      if (h >= m) {
        max = mid;
        left = mid + 1;
      } else {
          right = mid - 1;
      }
    }

    return max;
  }
  public static void main(String [] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(arr);
    long answer = binarySearch();

    System.out.println(answer);
  }
};