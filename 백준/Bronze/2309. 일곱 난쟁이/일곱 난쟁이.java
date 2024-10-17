import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 100;

    public String solution(int[] key){
        Arrays.sort(key);
        int total = 0;

        for (int i = 0; i < 9; i++) {
            total += key[i];
        }

        for(int i = 0; i < 8; i++){
            for (int j = i + 1; j < 9; j++) {
                if(total - key[i] - key[j] == MAX){
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < 9; k++){
                        if (k != i && k != j) {
                            sb.append(key[k]).append("\n");
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return null;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int[] n = new int[9];

        for(int i = 0; i < 9; i++){
            n[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(T.solution(n));
    }
}