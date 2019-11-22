import java.util.Scanner;

class TrieNode{
    TrieNode left;
    TrieNode right;
}

public class Main {
    
    static TrieNode root = new TrieNode();
    
    public static void insert(int val){
        
        TrieNode curr = root;
        
        for(int j = 31; j >= 0; j--){
            int b = val>>j & 1;
            if(b == 0){
                if(curr.left == null) curr.left = new TrieNode();
                curr = curr.left;
            } else {
                if(curr.right == null) curr.right = new TrieNode();
                curr = curr.right;
            }
        }
        
    }

    public static int func(int[] arr, int n){
        
        int currXor = 0;
        int maxXor = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            int currElement = arr[i];
            currXor = currXor ^ currElement;
            insert(currXor);
            TrieNode curr = root;
            int z = 0;
            for(int j = 31; j >= 0; j--){
                int b = (currXor>>j) & 1;
                if(b == 0){
                    if(curr.right != null){
                        curr = curr.right;
                        z = z + (int)Math.pow(2, j);
                    } else{
                        curr = curr.left;
                    }
                } else{
                    if(curr.left != null){
                        curr = curr.left;
                        z = z + (int)Math.pow(2, j);
                    } else{
                        curr = curr.right;
                    }
                }
            }
            
            maxXor = Math.max(z, maxXor);
        }
        
        return maxXor;
        
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(func(arr, n));
	}

}
