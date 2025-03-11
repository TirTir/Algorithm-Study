import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int max;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for(int c : course) {
            map = new HashMap<>();
            max = 0;
            
            for(String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr); // 사전 순 정렬
                dfs(new String(orderArr), "", 0, c);
            }
            
            for(String key : map.keySet()) {
                int value = map.get(key);

                if(value > 1 && max == value) {
                    list.add(key);
                }
            }
        }
        
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    private static void dfs(String order, String current, int index, int size) {
        if (current.length() == size) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            max = Math.max(max, map.get(current)); // 최대 주문 횟수 갱신
            return;
        }
        
        for (int i = index; i < order.length(); i++) {
            dfs(order, current + order.charAt(i), i + 1, size);
        }
    }
}