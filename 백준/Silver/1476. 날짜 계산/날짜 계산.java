import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] args) throws IOException{
        Main T = new Main();
        String[] input = br.readLine().split(" ");

        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (e != E || s != S || m != M) {
            e = e % 15 + 1;
            s = s % 28 + 1;
            m = m % 19 + 1;
            year++;
        }

        System.out.println(year);
    }
}