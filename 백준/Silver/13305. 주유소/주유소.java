import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws IOException{
			int n = Integer.parseInt(br.readLine());
			long[] len = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] price = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long totalCost = 0;
        long minPrice = price[0];

        for (int i = 0; i < len.length; i++) {
            totalCost += minPrice * len[i];
            if (price[i + 1] < minPrice) {
                minPrice = price[i + 1];
            }
        }

        System.out.println(totalCost);
		}
}