import java.util.Scanner;

class TrieNode{
    int count;
    TrieNode left;
    TrieNode right;
    TrieNode(int count){
        this.count = count;
    }
}

public class Main {

	static TrieNode root = new TrieNode(0);
    
    public static void insert(int val){
        
        TrieNode curr = root;
        curr.count++;
        
        for(int i = 31; i >= 0; i--){
            int bit = val>>i & 1;
            if(bit == 0){
                if(curr.left == null) curr.left = new TrieNode(0);
                curr = curr.left;
                curr.count++;
                
            } else{
                if(curr.right == null) curr.right = new TrieNode(0);
                curr = curr.right;
                curr.count++;
            }
        }
        
        return ;
        
    }
    
    public static long findNumberOfSubArrays(int[] arr, int n, int k){
        
        int currXor = 0;
        long ans = 0;
        
        for(int i = 0; i < n; i++){
            currXor = currXor ^ arr[i];
            TrieNode curr = root;
            for(int j = 31; j >= 0; j--){
                int b1 = k>>j & 1;
                int b2 = currXor>>j & 1;
                if(curr == null) break;
                if(b1 == 0){
                    if(b2 == 0){
                        curr = curr.left;
                    } else{
                        curr = curr.right;
                    }
                }
                else{
                    if(b2 == 0){
                        if(curr.left != null) ans += curr.left.count;
                        curr = curr.right;
                    } else{
                        if(curr.right != null) ans += curr.right.count;
                        curr = curr.left;
                    }
                }
            }
            
            insert(currXor);
            if(currXor < k) ans++;
            
        }
        
        return ans;
        
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int j = 0; j < t; j++){
            root = new TrieNode(0);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(findNumberOfSubArrays(arr, n, k));
        }

	}

}
