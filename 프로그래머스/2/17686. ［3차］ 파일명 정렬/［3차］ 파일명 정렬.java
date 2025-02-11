import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        String[] answer = new String[n];
        String[][] file = new String[n][4];
        
        for(int i = 0; i < n; i++) {
            file[i][3] = files[i];
            
            String[] str = files[i].split("\\.", 2); // 최대 2개로 분할
            str[0] = str[0].toLowerCase();
            file[i][2] = (str.length > 1) ? str[1] : ""; // 확장자 처리
            
            int j = 0;
            while (j < str[0].length() && !Character.isDigit(str[0].charAt(j))) j++;
            file[i][0] = str[0].substring(0, j); // HEAD 저장
            
            int k = j;
            while (k < str[0].length() && Character.isDigit(str[0].charAt(k))) k++;
            file[i][1] = (j < k) ? str[0].substring(j, k) : "0"; // NUMBER 저장
        }
            
        Arrays.sort(file, new Comparator<>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    // 숫자순 정렬 (String을 int로 변환)
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                // HEAD(문자열) 정렬
                return o1[0].compareTo(o2[0]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            answer[i] = file[i][3]; // 원본 파일명 그대로 사용
        }
        
        return answer;
    }
}