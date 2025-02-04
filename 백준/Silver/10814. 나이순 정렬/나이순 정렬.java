import java.io.*;
import java.util.*;

public class Main {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String [] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		List<String> name = new ArrayList<>();
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 나이
			arr[i][1] = i; // 가입
			name.add(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2){
				//나이가 같으면 가입한 순
				if (o1[0] != o2[0]) {
					return Integer.compare(o1[0], o2[0]);
				} else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++){
			sb.append(arr[i][0]).append(" ").append(name.get(arr[i][1])).append("\n");
		}

		System.out.println(sb.toString());
	}
};