import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MAX = 5, MIN = 3;

   public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int max = n / MAX + 1;
		int min = 0;

		while(max --> -1){
			int temp = n - MAX * max;
			if(temp % MIN == 0){
				min = temp / MIN;
				break;
			}
		}

		System.out.println(max != -1 ? max + min : max);
	}
}