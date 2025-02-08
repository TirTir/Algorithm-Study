import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르별 재생 횟수
        Map<String, Integer> genre = new HashMap<>();
        
        // 고유 번호 - 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++) {
            String name = genres[i];
            int play = plays[i];
            
            if(!music.containsKey(name)) {
                music.put(name, new HashMap<>());
            } 
               
            genre.put(name, genre.getOrDefault(name, 0) + play);
            music.get(name).put(i, play);
        }
        
        // 장르 정렬
        List<String> keySet = new ArrayList<>(genre.keySet());
        
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genre.get(o2).compareTo(genre.get(o1));
            }
        });
        
        // 정렬된 장르 순회
        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
            
            genre_key.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o2).compareTo(map.get(o1));
                }
            });
            
            answer.add(genre_key.get(0));
            if(genre_key.size() > 1) {
                answer.add(genre_key.get(1));
            } 
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}