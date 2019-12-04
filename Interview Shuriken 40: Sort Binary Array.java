public class SortBinaryArray{	

	public static void sortBinaryArray(int[] arr){
        
        int n = arr.length;
        int i = 0;
        int j = 0;
        
        for(i = 0; i < n; i++){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        
        return ;
	}
}
