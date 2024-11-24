import java.io.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int mul5 = n / 5;	// 5의 배수
		int mul25 = n / 25;	// 25의 배수
		int mul125 = n / 125;	// 125의 배수
		
		System.out.println(mul5+mul25+mul125);
	}
}