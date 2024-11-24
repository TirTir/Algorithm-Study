import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		int sum = 0; // 산술평균
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		// 중앙값
		Arrays.sort(arr);
		int mid = arr[n / 2];

		int max = Collections.max(map.values()); // 최빈값
		ArrayList<Integer> list = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
        list.add(entry.getKey());
    	}
		}

		Collections.sort(list);

		if (list.size() > 1) //최빈값이 여러개일 경우
      max = list.get(1);
    else //최빈값이 하나면
      max = list.get(0);
		
		int range = (int) Math.abs(arr[0] - arr[n-1]); // 범위

		System.out.println(Math.round((double) sum / n));
		System.out.println(mid);
		System.out.println(max);
		System.out.println(range);
	}
}