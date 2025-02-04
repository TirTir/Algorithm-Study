import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        
        // 대문자 -> 소문자
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();

		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
			char b = str1.charAt(i+1);
            
            if(Character.isLetter(a) && Character.isLetter(b)) { // 정규식
				String str = Character.toString(a) + Character.toString(b);
				list1.add(str);
			}
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
			char b = str2.charAt(i+1);

			if(Character.isLetter(a) && Character.isLetter(b)) {
				String str = Character.toString(a) + Character.toString(b);
				list2.add(str);
			}
        }

        Collections.sort(list1);
		Collections.sort(list2);
        
        for(String s : list1) {
			if(list2.remove(s)) {
				intersection.add(s); // 교집합
			}
			union.add(s);
		}
        
        for(String s : list2) {
			union.add(s);
		}
        
        double a = intersection.size();
		double b = union.size();

   		double jakard = 0;
	
		if(union.size() == 0) {
            jakard = 1;	// 공집합일 경우 1
        }
			
		else {
            jakard = (double) intersection.size() / (double) union.size();
        }
			
        return (int) (jakard * 65536);
    }
}