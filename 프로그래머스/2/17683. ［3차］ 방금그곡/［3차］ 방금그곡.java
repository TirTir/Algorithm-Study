import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = 0;
        
        m = replaceSharp(m);
        
        for(String s : musicinfos) {
            String[] musicin = s.split(",");
            
            String name = musicin[2];
            int start = getTime(musicin[0]);
            int fin = getTime(musicin[1]);
            
            String full = getFull(replaceSharp(musicin[3]), fin - start);
            
            if(full.contains(m) && fin - start > max) {
                // 시간이 제일 긴 음악 제목 반환
                max = fin - start;
                answer = name;
            }
        }
        
        // 음악이 없을 때에는 “(None)”을 반환
        if(max == 0) answer = "(None)";
        
        return answer;
    }
    
    private static int getTime(String str) {
        int time[] = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return time[0] * 60 + time[1];
    }
    
    private static String getFull(String str, int time) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        // 재생 시간만큼 멜로디 반복
        for (int i = 0; i < time; i++) {
            sb.append(str.charAt(index));
            index = (index + 1) % str.length();
        }
        return sb.toString();
    }
    
    private static String replaceSharp(String str) {
        return str.replace("C#", "c")
                 .replace("D#", "d")
                 .replace("E#", "e") // 추가
                 .replace("F#", "f")
                 .replace("G#", "g")
                 .replace("A#", "a")
                 .replace("B#", "b"); // 추가
    }
}