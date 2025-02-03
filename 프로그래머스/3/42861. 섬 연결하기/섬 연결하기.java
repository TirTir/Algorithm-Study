import java.util.*;

class Solution {
    static int[] parent;
    static int count = 0;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 비용 적은 순으로 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
            
        // 유니온-파인드
        parent = new int[n];
        
        // 초기화
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            int s = costs[i][0];
            int f = costs[i][1];
            int g = costs[i][2];
            
            // 사이클 여부 확인
            if(find(s) != find(f)) {
                union(s, f); // 두 섬 연결
                answer += g;
                count++;
                
                // 최소 신장 트리
                if (count == n - 1) break;
            }   
        }
        
        return answer;
    }
    
    public static void union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
	    y = find(y); //y의 부모노드 찾기
        
        if(x != y) parent[y] = x;
    }
    
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}