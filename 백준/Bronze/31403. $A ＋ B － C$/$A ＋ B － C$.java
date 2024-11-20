import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String [] args) throws IOException{
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();
		sb.append(a).append(b);

		System.out.println(a + b - c);
		System.out.println(Integer.parseInt(sb.toString()) - c);

	}
}