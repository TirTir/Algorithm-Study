import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] S = new int[row_end - row_begin + 1];
        
        // 튜플 정렬
        Arrays.sort(data, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int index = col - 1;
                if(o1[index] == o2[index]) {
                    return o2[0] - o1[0];
                }
                
                return o1[index] - o2[index];
            }
        });
        
        for(int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            // S_i번째 행의 튜플의 각 컬럼 값을 i로 나눈 나머지들의 합
            for (int value : data[i - 1]) {
                sum += value % i;
            }
            S[i - row_begin] = sum;
        }
        
        for (int num : S) {
            answer ^= num; // XOR 연산
        }

        return answer;
    }
}