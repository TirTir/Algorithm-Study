import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Integer solution(char[][] arr, int n){ // [y][x]
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 오른쪽 방향
                if (j + 1 < n) {
                    swap(arr, i, j, i, j+1);
                    answer = Math.max(answer, count(arr, n));
                    swap(arr, i, j, i, j+1);
                }

                // 아래쪽 방향
                if (i + 1 < n){
                    swap(arr, i, j, i+1, j);
                    answer = Math.max(answer, count(arr, n));
                    swap(arr, i, j, i+1, j);
                }
            }
        }

        return answer;
    }

    // Swap 함수
    private void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    // Count 함수
    private int count(char[][] arr, int n){
        int max = 0;

        // 행에서 찾기
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 1; j < n; j++){
                if(arr[i][j] == arr[i][j-1]){
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        // 열에서 찾기
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j] == arr[i-1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        System.out.print(T.solution(arr, n));
    }
}