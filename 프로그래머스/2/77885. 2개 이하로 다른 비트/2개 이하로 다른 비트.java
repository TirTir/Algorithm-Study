class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] ++; // 현재 값보다 큰 값
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        
        return answer;
    }
}