import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void printTriplets(int[] arr, int n){
        
        Arrays.sort(arr);
        
        for(int i = 0; i < n - 2; i++){
            int start = i + 1;
            int end = n - 1;
            while(start < end){
                int sum = arr[i] + arr[start] + arr[end];
                if(sum == 0){
                    System.out.println(arr[i] + " " + arr[start] + " " + arr[end]);
                    start++;
                } 
                else if(sum < 0) start++;
                else end--;
            }
        }
        
        return ;
        
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        printTriplets(arr, n);

	}

}
