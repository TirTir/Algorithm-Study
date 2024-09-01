class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                end = start + query[i] + 1;
            } else {
                start = start + query[i];
            }
        }

        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = arr[i];
        }

        return result;
    }
}