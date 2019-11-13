import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) if(arr[i] <= k) count ++;
        
        int currCount = 0;
        int minSwaps = n;
        for(int i = 0; i < count; i++){
            if(arr[i] <= k) currCount ++;
        }
        
        minSwaps = count - currCount;
        
        for(int i = count; i < n; i++){
            if(arr[i] <= k) currCount ++;
            if(arr[i - count] <= k) currCount --;
            minSwaps = Math.min(minSwaps, count - currCount);
        }
        
        System.out.println(minSwaps);

	}

}
