import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] abc = new int[26];

    public void solution(String arr){
        for(int i = 0; i < arr.length(); i++){
            int index = arr.charAt(i) - 'a'; 
            abc[index]++;
        }
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        String input = br.readLine();

        T.solution(input);
        StringBuffer sb = new StringBuffer();
        for(int a : abc){
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}