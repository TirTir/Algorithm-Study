import java.util.*;

class Solution {
    static int[] dx = {0, 1, -1};
    static int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int count = 1; // 빈칸 개수
        
        // 빈 삼각형 만들기
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        
        for(int i = 1; i < n; i++) {
            list.add(new int[i + 1]);
            count += i + 1;
        }
        
        int[] answer = new int[count];
        
        int num = 1;
        int index = 0; //방향
        int x = 0, y = 0; //현재 위치
        
        while (num <= count) {
            list.get(y)[x] = num++;
            
            int nx = x + dx[index];
            int ny = y + dy[index];
            
             if (ny >= n || nx >= list.get(ny).length || nx < 0 || ny < 0 || list.get(ny)[nx] != 0) {
                index = (index + 1) % 3;
                nx = x + dx[index];
                ny = y + dy[index];
            }
            
            x = nx;
            y = ny;
        }
        
        int d = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < list.get(i).length; j++) {
                 answer[d++] = list.get(i)[j];
            }
        }
        return answer;
    }
}