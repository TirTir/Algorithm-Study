class Solution {
    static int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
		int plus = 0;
		
		// 기본 행렬 생성
		matrix = new int[rows][columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				plus ++;
				matrix[i][j] = plus;
			}
		}
		
		for(int i=0; i<queries.length; i++) {
			answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
		}
        return answer;
    }
    
    // 회전 함수 만들기
	static int rotate(int x1, int y1, int x2, int y2) {
		// 행렬과 배열을 --로 맞춰주기 
		x1--;
		y1--;
		x2--;
		y2--;
		
		// 임의의 값 하나 잡아서 temp로 빼기
		int temp = matrix[x1][y1];
		// 최소값 초기화
		int min = temp;
		
		// 위
		for(int i=x1; i<x2; i++) {
			matrix[i][y1] = matrix[i + 1][y1];
			min = Math.min(min, matrix[i][y1]);
		}
		// 아래
		for(int i=y1; i<y2; i++) {
			matrix[x2][i] = matrix[x2][i + 1];
			min = Math.min(min, matrix[x2][i]);
		}
		// 오른쪽
		for(int i=x2; i>x1; i--) {
			matrix[i][y2] = matrix[i - 1][y2];
			min = Math.min(min, matrix[i][y2]);
		}
		// 왼쪽
		for(int i=y2; i>y1; i--) {
			matrix[x1][i] = matrix[x1][i - 1];
			min = Math.min(min, matrix[x1][i]);
		}
		matrix[x1][y1 + 1] = temp;
		return min;
	}
}