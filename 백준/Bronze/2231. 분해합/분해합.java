import java.io.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 1; i <= n; i++){
			int sum = i;

			String str = String.valueOf(i);
			for(int j = 0; j < str.length(); j++){
				sum += (str.charAt(j) - '0');
			}

			if(sum == n){
				answer = i;
				break;
			}
		}
		System.out.println(answer);
   }
}