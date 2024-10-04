import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static String list;

    public String solution(String list) {
        String[] words = list.split(" ");
        StringBuilder answer = new StringBuilder();

        for(String word : words){
            StringBuilder sb = new StringBuilder(word); 
            answer.append(sb.reverse()).append(" ");
        }
        return answer.toString().trim();
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++){
            list = br.readLine();
            String answer = T.solution(list);
            System.out.println(answer);
        }
    }
}