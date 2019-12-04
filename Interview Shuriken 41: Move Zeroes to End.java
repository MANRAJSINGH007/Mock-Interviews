public class PushZerosAtEnd {
	
	public static void pushZerosAtEnd(int[] arr){
        
        int n = arr.length;
        int i = 0;
        int j = 0;
        
        for(i = 0; i < n; i++){
            if(arr[i] != 0) arr[j++] = arr[i];
        }
        
        while(j < n) arr[j++] = 0;
        
        return ;

	}
}
