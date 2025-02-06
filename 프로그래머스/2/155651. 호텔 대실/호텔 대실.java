import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] books = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            books[i][0] = changeTime(book_time[i][0]); // 입실 시간
            books[i][1] = changeTime(book_time[i][1]) + 10; // 퇴실 후 10분 청소
        }
        
        Arrays.sort(books, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] book : books) {
            int checkIn = book[0];
            int checkOut = book[1];

            if (!pq.isEmpty() && pq.peek() <= checkIn) {
                pq.poll();
            }

            pq.add(checkOut);
        }
        
        return pq.size();
    }
    
    static public int changeTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}