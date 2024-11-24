import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int n = 3, m = 5;

	static String fizzBuzz(int num){
		if (num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		} else if (num % 3 == 0) {
			return "Fizz";
		} else if (num % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(num);
		}
	}

   public static void main(String [] args) throws IOException{
		int num = 0;

		for(int i = 3; i > 0; i--){
			String str = br.readLine();

			if(!str.equals("FizzBuzz") && !str.equals("Fizz") && !str.equals("Buzz")){
				num = Integer.parseInt(str) + i;
			}
		}

		System.out.println(fizzBuzz(num));
	}
}