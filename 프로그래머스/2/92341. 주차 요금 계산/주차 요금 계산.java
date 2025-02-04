import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basic = fees[1];
        
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> outTime = new TreeMap<>();
        
        for(String record : records) {
            String[] read = record.split(" ");
            int time = changeToTime(read[0]);
            String car = read[1];
            
            if(read[2].equals("IN")) {
                inTime.put(car, time);
                continue;
            }
            
            time = time - inTime.get(car); // 출차 - 입차
            inTime.put(car, -1);
            outTime.put(car, outTime.getOrDefault(car, 0) + time);
        }
        
        // 나머지 시간 정산
        for(Map.Entry<String, Integer> entry : inTime.entrySet()) {
            if(entry.getValue() != -1) {
                int total = (23 * 60 + 59) - entry.getValue();
                outTime.put(entry.getKey(), outTime.getOrDefault(entry.getKey(), 0) + total);
            }
        }
        
        // 요금 정산
        ArrayList<Integer> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : outTime.entrySet()) {
            
            if(entry.getValue() <= fees[0]) {
                list.add(basic);
                continue;
            }
            
            int fee = basic + (int)Math.ceil((double)(entry.getValue() - fees[0]) / fees[2]) * fees[3];
            list.add(fee);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static public int changeToTime(String time) {
        int[] t = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return (60 * t[0]) + t[1];
    }
}