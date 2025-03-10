import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0; // 이미 x와 y가 같다면 0번 연산

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> visited = new HashMap<>();
        
        queue.addLast(x);
        visited.put(x, 0); // 초기값

        while (!queue.isEmpty()) {
            int num = queue.removeFirst();
            int count = visited.get(num);

            int[] arr = {num + n, num * 2, num * 3};

            for (int next : arr) {
                if (next == y) return count + 1;
                if (next > y || visited.containsKey(next)) continue;

                queue.addLast(next);
                visited.put(next, count + 1);
            }
        }

        return -1;
    }
}