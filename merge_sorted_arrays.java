class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i1=0;
        int i2=0;
        
        int i=m-1;
        while(i>=0 && nums1[i]==0){
            i--;
        }
        
        i++;
        m=i;
        
        while(i1<m && i2<n){
            
            if(nums1[i1]<=nums2[i2]){
                i1++;
            }
            else{
                int temp=nums1[i1];
                nums1[i1]=nums2[i2];
                nums2[i2]=temp;
                int curr=i2;
                while(curr<n-1 && nums2[curr]>nums2[curr+1]){
                    int swap=nums2[curr];
                    nums2[curr]=nums2[curr+1];
                    nums2[curr+1]=swap;
                    curr++;
                }
                i1++;
            }
            
        }
        
        while(i2<n){
            nums1[i1]=nums2[i2];
            i1++;
            i2++;
        }
        
    }
}
