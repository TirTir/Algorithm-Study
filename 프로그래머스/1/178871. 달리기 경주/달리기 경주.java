import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i); // 선수 이름 -> 현재 등수
        }

        for (String call : callings) {
            int index = map.get(call);

            if (index > 0) {
                String frontPlayer = players[index - 1];
                players[index - 1] = call;
                players[index] = frontPlayer;

                map.put(call, index - 1);
                map.put(frontPlayer, index);
            }
        }
        
        return players;
    }
}