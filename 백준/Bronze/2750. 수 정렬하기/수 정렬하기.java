import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void quickSort(int[] arr, int start, int finish){
        if(start >= finish){
	        return ; 
	    }

        int pivot = start;
	    int left = start + 1; 
	    int right = finish;

        while(left <= right){
	        while(left <= finish && arr[left] <= arr[pivot]) left++; // 피벗보다 큰 데이터
	        while(right > start && arr[right] >= arr[pivot]) right--; // 피벗보다 작은 데이터
	        
	        int temp = arr[right];
	        
	        if(left > right){
	            arr[right] = arr[pivot];
	            arr[pivot] = temp;
	        } else{
	            arr[right] = arr[left];
	            arr[left] = temp;
	        }
	    }

        quickSort(arr, start, right -1);
	    quickSort(arr, right + 1, finish);
    }

    public static void main(String [] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length-1);

        for(int num : arr){
		    System.out.println(num);
		}
    }
}