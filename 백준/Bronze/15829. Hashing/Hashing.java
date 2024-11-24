import java.io.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int r = 31, m = 1234567891;

   public static void main(String [] args) throws IOException{
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long answer = 0, pow = 1;

		for(int i = 0; i < len; i++){
			int num = str.charAt(i) - 'a' + 1;
			answer += (num * pow) % 1234567891;
			pow = (pow * r) % 1234567891;
		}

		System.out.println(answer);
	 }
}