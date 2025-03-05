import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int o = 0, x = 0; // 카운트
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') o++;
                if (board[i].charAt(j) == 'X') x++;
            }
        }
        
        if (x > o || o - x > 1) return 0;
        if (o == 0 && x > 0) return 0;
        
        boolean oWin = isWinner(board, 'O');
        boolean xWin = isWinner(board, 'X');
        
        if (oWin && xWin) return 0; // 동시에 이겼는지
        if (oWin && o == x) return 0; // O가 이겼다면 O가 한 번 더 둬야 함
        if (xWin && o > x) return 0; // X가 이겼다면 X가 한 번 더 둬야 함

        return 1;
    }
    
    private boolean isWinner(String[] board, char player) {
        // 가로, 세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        // 대각선 검사
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;

        return false;
    }
}