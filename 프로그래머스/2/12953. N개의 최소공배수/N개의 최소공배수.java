class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            lcm *= (arr[i] / gcd(lcm, arr[i]));
        }
        
        return lcm;
    }
    
    static int gcd(int n, int m){

        while (m != 0) {
          int temp = n % m;
          n = m;
          m = temp;
        }

        return n;
    }
}