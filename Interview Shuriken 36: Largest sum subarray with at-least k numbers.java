import java.util.*;

public class Main {

	public static int func(int[] arr, int n, int k){
        
        int maxSum = 0;
        int currSum = 0;
        
        int[] sum = new int[n];
        int s = 0;
        for(int i = 0; i < n; i++){
            s += arr[i];
            sum[i] = s;
        }
        
        Deque<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            q.addLast(i);
            currSum += arr[i];
        }
        
        maxSum = currSum;
        
        for(int i = k; i < n; i++){
            
            q.add(i);
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            
            if(q.size() > k){
                int start = q.peekFirst();
                int currExcess = q.size() - k;
                int end = start + currExcess - 1;
                int prefixSum = sum[end];
                if(start != 0) prefixSum -= sum[start - 1];
                if(prefixSum < 0){
                    while(q.peekFirst() != end){
                        currSum -= arr[q.removeFirst()];
                    }
                    
                    currSum -= arr[q.removeFirst()];
                    maxSum = Math.max(currSum, maxSum);
                }
            }
        }
        
        return maxSum;
        
    }
    
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println(func(arr, n, k));

	}

}
