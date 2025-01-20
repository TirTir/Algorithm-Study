class Solution {
    public int solution(int n) {
        int countOnes = Integer.bitCount(n);
        int next = n + 1;
        
        while (true) {
            if (Integer.bitCount(next) == countOnes) {
                return next;
            }
            next++;
        }
    }
}