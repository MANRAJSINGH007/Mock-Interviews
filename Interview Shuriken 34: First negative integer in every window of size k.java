import java.util.*;

public class Main {

	
    public static void firstNegative(int[] arr, int n, int k){
        
        
        // push indexes into the dequeue
        Deque<Integer> dequeue = new LinkedList<>();
        
        for(int i = 0; i < k - 1; i++){
            
            int curr = arr[i];
            dequeue.add(i);
            while(dequeue.size() > 0 && (arr[dequeue.peekFirst()] >= 0 || dequeue.peekFirst() <= i - k)){
                dequeue.removeFirst();
            }
        }
        
        for(int i = k - 1; i < n ; i++){
            
            int curr = arr[i];
            dequeue.add(i);
            
            while(dequeue.size() > 0 && (arr[dequeue.peekFirst()] >= 0 || dequeue.peekFirst() <= i - k)){
                dequeue.removeFirst();
            }
            
            if(dequeue.size() > 0)
                System.out.print(arr[dequeue.peekFirst()] + " ");
            else
           		System.out.print(0 + " ");
            
        }
        
        return ;
        
        
    }
    
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        firstNegative(arr, n, k);

	}

}
