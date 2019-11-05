import java.util.Scanner;

public class Main {
    
    public static boolean check(int[] unique, int[] arr){
        
        for(int i = 0; i < 256; i++){
            if(unique[i] == 1 && arr[i] == 0) return false;
        }
        
        return true;
        
    }
    
    public static void findMinimumLengthSubstring(String str){
        
        int n = str.length();
        
        int[] unique = new int[256];
        int[] arr = new int[256];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            char curr = str.charAt(i);
            int index = (int)(curr);
            if(unique[index] == 0) count++;
            unique[index] = 1;
        }
        
        for(int i = 0; i < count; i++){
            char curr = str.charAt(i);
            int index = (int)curr;
            arr[index]++;
        }
        
        int start = 0;
        int end = count - 1;
        int min = n;
        
        int st = 0;
        int e = n - 1;
        
        while(end < n){
            
            while(end < n && !check(unique, arr)){
                end++;
                if(end == n) break;
                int index = (int)str.charAt(end);
                arr[index]++;
            }
            
            if(end != n){
               if(min > end - start + 1){
                   min = end - start + 1;
                   e = end;
                   st = start;
               }
            }
            
            while(start <= end - count + 1 && check(unique, arr)){
                if(min > end - start + 1){
                    min = end - start + 1;
                    e = end;
                    st = start;
                }
                int index = (int)str.charAt(start);
                arr[index]--;
                start++;
            }
            
        }
                  
        System.out.println(str.substring(st, e + 1));
        return ;
        
    }

	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        
        findMinimumLengthSubstring(str);

	}

}
