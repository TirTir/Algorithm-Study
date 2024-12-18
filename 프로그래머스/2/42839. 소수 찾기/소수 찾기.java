import java.util.*;
import java.io.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        int[] arr = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        
        Set<Integer> set = new HashSet<>();
        
         // 숫자 조합
        boolean[] visited = new boolean[n];
        dfs(arr, "", visited, set);
        
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    static void dfs(int[] arr, String current, boolean[] visited, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, current + arr[i], visited, set); // 재귀호출
                visited[i] = false; // 백트래킹
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}