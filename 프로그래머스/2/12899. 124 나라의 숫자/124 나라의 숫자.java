class Solution {
    static int[] num = {4, 1, 2};
    public String solution(int n) {
        StringBuilder answer = new StringBuilder(); // 시간초과 방지
        
        while(n > 0) {
            
            int temp = num[n % 3];
            answer.insert(0, temp);
            
            n = (n - 1) / 3;
        }

        return answer.toString();
    }
}