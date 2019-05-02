class Solution {
    
    public void sortColors(int[] arr) {
        
        int n=arr.length;
        
        if(n==1){
            return ;
        }
        
        int s=0;
        int e=n-1;
        int k=0;
        
        while(k<n && arr[k]==0){
            k++;
            s++;
        }
        
        if(k==n){
            return ;
        }
        
        while(k<=e){
            
            while(k<=e && arr[k]==1){
                k++;
            }
            
            if(k>e){
                return ;
            }
            
            if(arr[k]==0){
                arr[k]=arr[s];
                arr[s]=0;
                s++;
                k++;
            }
            
            else if(arr[k]==1){
                k++;
            }
            
            else{
                arr[k]=arr[e];
                arr[e]=2;
                e--;
            }
            
        }
        
        return ;
        
        
    }
}
